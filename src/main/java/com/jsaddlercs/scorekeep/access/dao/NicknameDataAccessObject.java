package com.jsaddlercs.scorekeep.access.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class NicknameDataAccessObject<T> {
	protected final Connection connection;
	protected final JdbcTemplate jdbcTemplate;
	public NicknameDataAccessObject(JdbcTemplate template)  {
		this.jdbcTemplate = template;
		try{this.connection = template.getDataSource().getConnection();}
		catch(SQLException sqle) { throw new RuntimeException("Connection unavailable"); }
	}
	
	public abstract T findById(String id);
	
}
