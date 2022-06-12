package com.jsaddlercs.scorekeep.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsaddlercs.scorekeep.basic.RecordingsImported;
import com.jsaddlercs.scorekeep.data.db.ScoreRepository;

@Controller
@RequestMapping
public class ViewController {
	final ScoreRepository scoreRepository; 
	
	public ViewController(ScoreRepository scoreRepository, RecordingsImported importedRecordings) {
		this.scoreRepository = scoreRepository;
	}
	
	@GetMapping("/")
	public String getAllScores(Model model) { 
		model.addAttribute("recs", scoreRepository.findAll());
		return "scoresGreeting";
	}
	
	@GetMapping("/scores")
	public String getAllScoresTwo(Model model) { 
		model.addAttribute("recs", scoreRepository.findAll());
		return "scoresGreeting";
	}
	
}
