package com.jsaddlercs.keepscore.data.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ScoreSet {
	private TreeMap<Integer, List<ScoreSetRecording>> scoreSet;
	private String game;
	
	public ScoreSet() { }
	
	public ScoreSet(String game, Map<Integer, List<ScoreSetRecording>> scoreSet) { 
		this.game = game;
		this.scoreSet = new TreeMap<>(scoreSet);
	} 
	
	public TreeMap<Integer, List<ScoreSetRecording>> getScoreSet() {
		return scoreSet = (scoreSet == null ? new TreeMap<Integer, List<ScoreSetRecording>>() : scoreSet); 
	}
	
	public void setScoreSet(Map<Integer, List<ScoreSetRecording>> scoreSet) {
		this.scoreSet = new TreeMap<>(scoreSet);
	}
	

	public void setScores(Integer key, List<ScoreSetRecording> values) { 
		getScoreSet().put(key, values);
	}
	
	public String getGame() { return game; }
	public void setGame(String game) { this.game = game; }
	
	@Override
	public String toString() {
		return "ScoreSet [scoreSet=" + scoreSet + ", game=" + game + "]";
	}
	
}
