package com.jsaddlercs.scorekeep;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsaddlercs.scorekeep.data.model.Person;
import com.jsaddlercs.scorekeep.data.model.ScoreRecording;


public class RecordingsFromFile {

	public List<RecordingFromFile> recordings;
	
	public static RecordingsFromFile getFileContent(File fileToImport) throws IOException { 
		return RecordingsFromFile.read(fileToImport);
	}
	
	public static List<ScoreRecording> createRecordingsFromFileContent(RecordingsFromFile theRecordings) { 
		return theRecordings.recordings.stream().map( pf -> {
			ScoreRecording sr = new ScoreRecording(
				pf.order,
				pf.personNickname,
				pf.newScore);
			sr.setGameId(pf.gameId);
			return sr;
		}
		).collect(Collectors.toList());
	}
	public static List<ScoreRecording> getRecordings(File fileToImport) throws IOException { 
		RecordingsFromFile theRecordings = RecordingsFromFile.read(fileToImport);
		return theRecordings.recordings.stream().map( pf -> {
			ScoreRecording sr = new ScoreRecording(
				pf.order,
				pf.personNickname,
				pf.newScore);
			sr.setGameId(pf.gameId);
			return sr;
		}
		).collect(Collectors.toList());
	}
	
	public static List<Person> createPersons(RecordingsFromFile theRecordings){ 
		List<Person> listPerson = new ArrayList<>();
		recordingLoop:
		for(RecordingFromFile rf : theRecordings.recordings) { 
			for(int j = 0; j < listPerson.size(); j++) 
				if(rf.personName.equals(listPerson.get(j).getPersonName())) 
					continue recordingLoop;	// don't add duplicate personName entries	
			
			// add a unique person to listPerson
			listPerson.add(new Person(rf.personName, rf.personNickname));
		}
		return listPerson;
	}

	public static RecordingsFromFile read(File fileToImport) throws IOException {
		return new ObjectMapper().setVisibility(FIELD, ANY)
				.readValue(fileToImport, new TypeReference<RecordingsFromFile>() {});	
	}
	
	private static class RecordingFromFile { 
		private Integer order;
		private String personNickname;
		private String personName;
		private Integer newScore;
		private String gameId;
		
		
	}
}
