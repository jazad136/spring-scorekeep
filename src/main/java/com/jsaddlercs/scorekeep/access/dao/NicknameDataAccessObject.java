package com.jsaddlercs.scorekeep.access.dao;

import java.sql.Connection;

public abstract class NicknameDataAccessObject<T> {
	protected final Connection connection;
	
	public NicknameDataAccessObject(Connection connection) {
		this.connection = connection;
	}
	
	public abstract T findById(String id);
	
}
