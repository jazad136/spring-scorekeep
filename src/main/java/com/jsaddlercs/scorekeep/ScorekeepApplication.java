package com.jsaddlercs.scorekeep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsaddlercs.scorekeep.access.dao.ScoreDAO;
import com.jsaddlercs.scorekeep.basic.RecordingsImported;

@SpringBootApplication
public class ScorekeepApplication implements CommandLineRunner{

	
	@Autowired RecordingsImported imported;
//	@Autowired ScoreRepository scoreRepository;
	@Autowired ScoreDAO scoreDao;
//	private static final Logger logger = LoggerFactory.getLogger(ScorekeepApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ScorekeepApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("*** Score Recordings ***");

		for(int i = 0; i < imported.size(); i++) 
			imported.get(i).setRecordingId(i);
		
		imported.stream().forEach(System.out::println);
//		scoreDao.saveAll(imported);
	}	
}
