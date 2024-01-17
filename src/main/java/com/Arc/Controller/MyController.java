package com.Arc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Arc.Model.Question;
import com.Arc.Service.QuestionSerivce;

@Controller
@RequestMapping("/questions")
public class MyController {

	@Autowired
	private QuestionSerivce questionService;
	
	@PostMapping("/save")
	public ResponseEntity<Question>  SaveQuestion(@RequestBody Question theQuestions) {
		return  questionService.SaveQuestion(theQuestions);
	} 
	
	@GetMapping("/get/{Category}")
	public ResponseEntity<Question> GetQuestion(@PathVariable String Category) {
		return questionService.GetQuestion(Category);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Question>> GetAllQuestion(){
		return questionService.GetAllQuestion();
	}
	
	@PutMapping("/update")
	public Question Update(@RequestBody Question theQuestions) {
		return questionService.Update(theQuestions);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteQuestion(@PathVariable int id) {
		return questionService.DeleteQuestion(id);
	}
	
	
}
