package com.Arc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Arc.Dto.QuestionWrapper;
import com.Arc.Dto.Response;
import com.Arc.Model.Quiz;
import com.Arc.Service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> SaveQuiz( @RequestParam String category, @RequestParam String title, @RequestParam int numQ){
		return quizService.SaveQuiz(category, title, numQ);
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		return  quizService.GetQuiz(id);
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> Test(@PathVariable int id, @RequestBody List<Response> response){
		return quizService.Test(id, response);
	}
}
