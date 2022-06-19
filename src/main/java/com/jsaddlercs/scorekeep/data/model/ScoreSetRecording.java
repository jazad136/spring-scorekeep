package com.jsaddlercs.scorekeep.data.model;

import java.math.BigInteger;

public class ScoreSetRecording {
	
	private Integer order;
	private String personName;
	private String personNickname;
	private Integer newScore;
	private String gameId;
	private BigInteger recordingId;
	
	public ScoreSetRecording() { } 
	
	public ScoreSetRecording(Integer order, String personNickname, Integer score) {
		this.order = order;
		this.personNickname = personNickname;
		this.newScore = score;
	}

	public ScoreSetRecording(Integer order, String personNickname, Integer newScore, String gameId) {
		this.order = order;
		this.personNickname = personNickname;
		this.newScore = newScore;
		this.gameId = gameId;
	}

	public Integer getOrder() { return order; }
	public void setOrder(Integer order) { this.order = order; }
	
	public String getPersonNickname() { return personNickname; }
	public void setPersonNickname(String personName) { this.personNickname = personName; }
	
	public String getPersonName() { return personName; }
	public void setPersonName(String personName) { this.personName = personName; }

	public Integer getNewScore() { return newScore; }
	public void setNewScore(Integer score) { this.newScore = score; }
	
	public String getGameId() { return gameId; }
	public void setGameId(String gameId) { this.gameId = gameId; }

	public BigInteger getRecordingId() { return recordingId; }
	public void setRecordingId(Long value) { this.recordingId = BigInteger.valueOf(value); }
	public void setRecordingId(Integer value) { this.recordingId = BigInteger.valueOf(value); }
	public void setRecordingId(BigInteger value) { this.recordingId = value; }

	@Override
	public String toString() {
		return "ScoreRecording [order=" + order + ", personNickname=" + personNickname + ", newScore=" + newScore
				+ ", gameId=" + gameId + "]";
	}

	
	
	
}
