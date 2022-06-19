package com.jsaddlercs.scorekeep.data.model;

import java.util.HashMap;
import java.util.List;

public class ScoreSet {
	private HashMap<Integer, List<ScoreSetRecording>> scoreSet;
	private String game;
	public ScoreSet() { }
	
	public HashMap<Integer, List<ScoreSetRecording>> getScoreSet() {
		return scoreSet;
	}
	public void setScoreSet(HashMap<Integer, List<ScoreSetRecording>> scoreSet) {
		this.scoreSet = scoreSet;
	}
	public void setScores(Integer key, List<ScoreSetRecording> values) { 
		this.scoreSet.put(key, values);
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	
	
}
