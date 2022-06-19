package com.jsaddlercs.scorekeep.data.model;

import java.math.BigInteger;

public class ScoreSetRecording implements Comparable<ScoreSetRecording> {
	
	private Integer order;
	private String personName;
	private String personNickname;
	private Integer score;
	private String gameName;
	
	public ScoreSetRecording() { } 
	
	public ScoreSetRecording(Integer order, String personNickname, Integer score) {
		this.order = order;
		this.personNickname = personNickname;
		this.score = score;
	}

	public ScoreSetRecording(Integer order, String personNickname, Integer score, String gameName) {
		this.order = order;
		this.personNickname = personNickname;
		this.score = score;
		this.gameName = gameName;
	}

	public Integer getOrder() { return order; }
	public void setOrder(Integer order) { this.order = order; }
	
	public String getPersonNickname() { return personNickname; }
	public void setPersonNickname(String personName) { this.personNickname = personName; }
	
	public String getPersonName() { return personName; }
	public void setPersonName(String personName) { this.personName = personName; }

	public Integer getScore() { return score; }
	public void setScore(Integer score) { this.score = score; }
	
	public String getGameName() { return gameName; }
	public void setGameName(String gameId) { this.gameName = gameId; }

//	public BigInteger getRecordingId() { return recordingId; }
//	public void setRecordingId(Long value) { this.recordingId = BigInteger.valueOf(value); }
//	public void setRecordingId(Integer value) { this.recordingId = BigInteger.valueOf(value); }
//	public void setRecordingId(BigInteger value) { this.recordingId = value; }

	@Override
	public String toString() {
		return "ScoreSetRecording [order=" + order + ", personNickname=" + personNickname + ", newScore=" + score
				+ ", gameName=" + gameName + "]";
	}

	@Override
	public int compareTo(ScoreSetRecording o) {
		return Integer.compare(this.order, o.order);
	}

	
	
	
}
