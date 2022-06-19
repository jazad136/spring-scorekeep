package com.jsaddlercs.scorekeep.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsaddlercs.scorekeep.access.dao.ScoreDAO;
import com.jsaddlercs.scorekeep.data.model.GameCreationDto;
import com.jsaddlercs.scorekeep.data.model.ScoreCreationDto;
import com.jsaddlercs.scorekeep.data.model.ScoreSetRecording;

@Controller
@RequestMapping
public class ViewController {
	
	ScoreDAO scoreDao;
	
	public ViewController(ScoreDAO scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	@GetMapping("/")
	public String getAllScores(Model model) { 
		model.addAttribute("recs", scoreDao.findAll());
		return "scoresGreeting";
	}
	
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		GameCreationDto gameForm = new GameCreationDto();
		model.addAttribute("form", gameForm);
		return "new";
	}
	
	@GetMapping("/addscore") 
	public String showAddScoreForm(Model model) { 
		ScoreSetRecording rec = scoreDao.getLastScore();
		ScoreCreationDto scoreForm = new ScoreCreationDto(rec.getOrder(), rec.getPersonNickname(), rec.getGameName());
		model.addAttribute("form", scoreForm);
		return "addscore";
	}
	
}
