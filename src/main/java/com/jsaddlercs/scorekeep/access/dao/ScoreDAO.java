package com.jsaddlercs.scorekeep.access.dao;

import java.sql.Connection;

import com.jsaddlercs.scorekeep.data.model.ScoreSet;

public class ScoreDAO extends NicknameDataAccessObject<ScoreSet>{
	public ScoreDAO(Connection connection) {
		super(connection);
	}
//	@Override
//	public ScoreSet findById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
