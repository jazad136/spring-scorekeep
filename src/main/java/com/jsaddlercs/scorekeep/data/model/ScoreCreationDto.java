package com.jsaddlercs.scorekeep.data.model;

public class ScoreCreationDto {
	private Integer order;
	private String personNickname;
	private Integer newScore;
	private String gameId;
	
	public ScoreCreationDto(Integer order, String personNickname, String gameId) { 
		this.order = order;
		this.personNickname = personNickname;
		this.gameId = gameId;
	}
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getPersonNickname() {
		return personNickname;
	}
	public void setPersonNickname(String personNickname) {
		this.personNickname = personNickname;
	}
	public Integer getNewScore() {
		return newScore;
	}
	public void setNewScore(Integer newScore) {
		this.newScore = newScore;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
}
