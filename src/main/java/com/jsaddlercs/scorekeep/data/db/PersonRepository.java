package com.jsaddlercs.scorekeep.data.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jsaddlercs.scorekeep.data.model.Person;

public interface PersonRepository 
	extends MongoRepository<Person, String>, PagingAndSortingRepository<Person, String> 
{

}
