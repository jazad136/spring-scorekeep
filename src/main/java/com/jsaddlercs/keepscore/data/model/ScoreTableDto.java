package com.jsaddlercs.keepscore.data.model;

import java.util.List;
import java.util.Map;

public class ScoreTableDto {
	
	public ScoreSetRecording[][] record;
	
	
	public ScoreTableDto() { }

	public ScoreTableDto(ScoreSet scoreSet) {
		int keySize = scoreSet.getScoreSet().size();
		record = new ScoreSetRecording[keySize][];
		int count = 0;
 
		
		for(Map.Entry<Integer, List<ScoreSetRecording>> kv: scoreSet.getScoreSet().entrySet()) { 
			record[count] = new ScoreSetRecording[kv.getValue().size()];
			int recCount = 0;
			for(ScoreSetRecording rec : kv.getValue())  {
				record[count][recCount] = rec;
				recCount++;
			}
			count++;
		}
	}

	public ScoreSetRecording[][] getRecord() {
		return record;
	}

	public void setRecord(ScoreSetRecording[][] record) {
		this.record = record;
	}
	
}
