package com.jsaddlercs.scorekeep;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jsaddlercs.keepscore.KeepscoreApplication;
import com.jsaddlercs.keepscore.access.dao.ScoreDAO;
import com.jsaddlercs.keepscore.data.model.ScoreSet;
import com.jsaddlercs.keepscore.data.model.ScoreSetRecording;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes=KeepscoreApplication.class)
class KeepscoreApplicationTests {

	@Autowired ScoreDAO scoreDao;
	
	@Test
	void personNicknameMatches() { 
		ScoreSet set = scoreDao.findById("Jon");
		List<ScoreSetRecording> jonRec = set.getScoreSet().get(1);
		assertThat(jonRec.get(0).getPersonNickname()).isEqualTo("Jon");
	}
	@Test
	void contextLoads() {
	}

}
