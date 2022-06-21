package com.jsaddlercs.keepscore.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.jsaddlercs.keepscore.RecordingsFromFile;
import com.jsaddlercs.keepscore.data.model.Person;
import com.jsaddlercs.keepscore.data.model.ScoreRecording;

@Component
public class RecordingsImported extends ArrayList<ScoreRecording> {
	
	public List<Person> scorePersons;
	
	public RecordingsImported(Environment env) { 
		String inf = env.getProperty("kps.importFile", "");
		RecordingsFromFile rff;
		if(inf.isBlank()) 
			throw new RuntimeException("Import File (kps.importFile) was not found in Spring Boot properties");
		
		try { 
			ClassPathResource importRes = new ClassPathResource(inf);
			rff = RecordingsFromFile.getFileContent(importRes.getFile()); 
		} catch(IOException e) { 
			throw new RuntimeException("Could not read recordings from import file: " + inf); 
		}
		
		addAll(RecordingsFromFile.createRecordingsFromFileContent(rff));
		scorePersons = RecordingsFromFile.createPersons(rff);
	}
}
