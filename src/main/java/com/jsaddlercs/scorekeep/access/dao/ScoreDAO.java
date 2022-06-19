package com.jsaddlercs.scorekeep.access.dao;

import java.sql.Connection;

import org.springframework.stereotype.Component;

import com.jsaddlercs.scorekeep.basic.RecordingsImported;
import com.jsaddlercs.scorekeep.data.model.ScoreSet;
import com.jsaddlercs.scorekeep.data.model.ScoreSetRecording;

@Component
public class ScoreDAO extends NicknameDataAccessObject<ScoreSet>{
	
	public ScoreDAO(Connection connection) {
		super(connection);
	}
	
	public final String GET_ONE = "SELECT recording_id, turn_order, person_nickname, person_name, new_score, game_id "
			+ "FROM score"
			+ "WHERE recording_id=?";
	@Override
	public ScoreSet findById(String id) {
		ScoreSet scoreSet = new ScoreSet();
		
		
	}
	public ScoreSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public ScoreSetRecording getLastScore() {
		// TODO Auto-generated method stub
		return null;
	}
	public void saveAll(RecordingsImported imported) {
		// TODO Auto-generated method stub
		
	}
}
