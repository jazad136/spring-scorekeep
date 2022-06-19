package com.jsaddlercs.scorekeep.access.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.jsaddlercs.scorekeep.basic.RecordingsImported;
import com.jsaddlercs.scorekeep.data.model.ScoreSet;
import com.jsaddlercs.scorekeep.data.model.ScoreSetRecording;

@Component
public class ScoreDAO extends NicknameDataAccessObject<ScoreSet>{
	
	
	public ScoreDAO(JdbcTemplate jdbcTemplate) { 
		super(jdbcTemplate);
	} 
	
	public final String GET_ALL = 
			"SELECT s.turn_order, s.person_nickname, "
			+ "s.person_name, s.new_score, g.common_name "
			+ "FROM score s join game g on s.game_id=g.id";
	
//	public final String GET_ONE = "SELECT * from score WHERE person_nickname=?";
	public final String GET_ONE = "SELECT s.turn_order, s.person_nickname, "
			+ "s.person_name, s.new_score, g.common_name"
			+ "FROM score s join game g on s.game_id=g.id WHERE person_nickname=?";
	
	public final String GET_ONE_BY_GAME = "SELECT s.turn_order, s.person_nickname, "
			+ "s.person_name, s.new_score, g.common_name"
			+ "FROM score s join game g on s.game_id=g.id "
			+ "WHERE s.person_nickname=? "
			+ "and g.common_name=?";
	
	/*
jonnyscorekeep=# SELECT s.turn_order, s.person_nickname, s.person_name, s.new_score, g.common_n
ame FROM score s join game g on s.game_id=g.id WHERE person_nickname='Jon';
 turn_order | person_nickname |   person_name    | new_score | common_name
------------+-----------------+------------------+-----------+-------------
          1 | Jon             | Jonathan Saddler |        12 | Scrabble
          2 | Jon             | Jonathan Saddler |        31 | Scrabble
          3 | Jon             | Jonathan Saddler |        60 | Scrabble
(3 rows)

	 */
	
	private static int idxIntTurnOrder = 1;
	private static int idxStrPersonNickname = 2;
	private static int idxStrPersonName = 3;
	private static int idxIntNewScore = 4;
	private static int idxStrCommonName = 5;
	
	@Override
	public ScoreSet findById(String personNickname) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ALL, personNickname);
		ScoreSet scoreSet = new ScoreSet();
		List<ScoreSetRecording> localRecordings;
		while(rs.next()) { 
			ScoreSetRecording localRec = new ScoreSetRecording();
			localRec.setOrder(rs.getInt(idxIntTurnOrder));
			localRec.setScore(rs.getInt(idxIntNewScore));
			localRec.setPersonName(rs.getString(idxStrPersonName));
			localRec.setPersonNickname(rs.getString(idxStrPersonNickname));
			localRec.setGameName(rs.getString(idxStrCommonName));
			if(!scoreSet.getScoreSet().containsKey(localRec.getOrder())) { 
				localRecordings = new ArrayList<>();
				scoreSet.getScoreSet().put(localRec.getOrder(), localRecordings);
			}
			else { 
				localRecordings = scoreSet.getScoreSet().get(localRec.getOrder());
			}
			localRecordings.add(localRec);
		}
		return scoreSet;
	}
	
	public ScoreSet findByIdAndGame(String personNickname, String gameCommonName) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ONE, personNickname, gameCommonName);
		ScoreSet scoreSet = new ScoreSet();
		List<ScoreSetRecording> localRecordings;
		while(rs.next()) { 
			ScoreSetRecording localRec = new ScoreSetRecording();
			localRec.setOrder(rs.getInt(idxIntTurnOrder));
			localRec.setScore(rs.getInt(idxIntNewScore));
			localRec.setPersonName(rs.getString(idxStrPersonName));
			localRec.setPersonNickname(rs.getString(idxStrPersonNickname));
			localRec.setGameName(rs.getString(idxStrCommonName));
			if(!scoreSet.getScoreSet().containsKey(localRec.getOrder())) { 
				localRecordings = new ArrayList<>();
				scoreSet.getScoreSet().put(localRec.getOrder(), localRecordings);
			}
			else { 
				localRecordings = scoreSet.getScoreSet().get(localRec.getOrder());
			}
			localRecordings.add(localRec);
		}
		return scoreSet;
	}
	public ScoreSet mapResultSetToScoreSet(ResultSet rs) throws SQLException, DataAccessException { 
		ScoreSet scoreSet = new ScoreSet();
		List<ScoreSetRecording> localRecordings;
		while(rs.next()) { 
			ScoreSetRecording localRec = new ScoreSetRecording();
			localRec.setOrder(rs.getInt(idxIntTurnOrder));
			localRec.setScore(rs.getInt(idxIntNewScore));
			localRec.setPersonName(rs.getString(idxStrPersonName));
			localRec.setPersonNickname(rs.getString(idxStrPersonNickname));
			localRec.setGameName(rs.getString(idxStrCommonName));
			if(!scoreSet.getScoreSet().containsKey(localRec.getOrder())) { 
				localRecordings = new ArrayList<>();
				scoreSet.getScoreSet().put(localRec.getOrder(), localRecordings);
			}
			else { 
				localRecordings = scoreSet.getScoreSet().get(localRec.getOrder());
			}
			localRecordings.add(localRec);
		}
		return scoreSet;
	}
//	public ScoreSet findByTurn(
	public ScoreSet findAll() {
		ResultSetExtractor<ScoreSet> allExtractor = (rs) -> mapResultSetToScoreSet(rs);
		ScoreSet scoreSet = jdbcTemplate.query(GET_ALL, allExtractor);
		return scoreSet;
//		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ALL);
//		ScoreSet scoreSet = new ScoreSet();
//		List<ScoreSetRecording> localRecordings = null;
//		while(rs.next()) { 
//			ScoreSetRecording localRec = new ScoreSetRecording();
//			localRec.setOrder(rs.getInt(idxIntTurnOrder));
//			localRec.setScore(rs.getInt(idxIntNewScore));
//			localRec.setPersonName(rs.getString(idxStrPersonName));
//			localRec.setPersonNickname(rs.getString(idxStrPersonNickname));
//			localRec.setGameName(rs.getString(idxStrCommonName));
//			if(!scoreSet.getScoreSet().containsKey(localRec.getOrder())) { 
//				localRecordings = new ArrayList<>();
//				scoreSet.getScoreSet().put(localRec.getOrder(), localRecordings);
//			}
//			else { 
//				localRecordings = scoreSet.getScoreSet().get(localRec.getOrder());
//			}
//			localRecordings.add(localRec);
//		}
//		return scoreSet;
				
	}
	public ScoreSetRecording getLastScore() {
		// TODO Auto-generated method stub
		return null;
	}
	public void saveAll(RecordingsImported imported) {
		// TODO Auto-generated method stub
		
	}
}
