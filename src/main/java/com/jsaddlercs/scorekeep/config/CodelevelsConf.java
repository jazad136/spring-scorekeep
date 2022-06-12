package com.jsaddlercs.scorekeep.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class CodelevelsConf {
	@Bean
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .username("postgres")
	        .password("password")
	        
//	        .username("postgres")
//	        .password("CircleGreen!3")
//	        .url("jdbc:postgresql://localhost:5432/sclipr")
//	        .driverClassName("org.postgresql.Driver")
	        .build();
	}
}
