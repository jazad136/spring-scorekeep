package com.jsaddlercs.scorekeep.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScorekeepConfig {
	@Bean
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
//	        .username("postgres")
//	        .password("password")
	        
	        .username("postgres")
	        .password("password")
	        .url("jdbc:postgresql://localhost:5432/javascorekeep")
	        .driverClassName("org.postgresql.Driver")
	        .build();
	}
}