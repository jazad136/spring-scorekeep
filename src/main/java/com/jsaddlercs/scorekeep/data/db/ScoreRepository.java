package com.jsaddlercs.scorekeep.data.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jsaddlercs.scorekeep.data.model.ScoreRecording;

public interface ScoreRepository extends MongoRepository<ScoreRecording, Long>, PagingAndSortingRepository<ScoreRecording, Long>{
	
}
