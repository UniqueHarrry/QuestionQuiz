 package com.Arc.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Arc.Dto.QuestionWrapper;
import com.Arc.Dto.Response;
import com.Arc.Model.Question;
import com.Arc.Model.Quiz;
import com.Arc.Repository.QuestionRepository;
import com.Arc.Repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	public ResponseEntity<String> SaveQuiz(String category, String title, int numQ) {
		
		List<Question> question = questionRepository.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(question);
		quizRepository.save(quiz);
		
		return new ResponseEntity<>("sucess", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> GetQuiz(int id) {
		 Optional<Quiz> quiz  = quizRepository.findById(id);
		 List<Question> questionfromdb = quiz.get().getQuestion();
		 List<QuestionWrapper> questionforuser = new ArrayList<>();
		 for(Question q : questionfromdb) {
			 
			 QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestions(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption3(), q.getOption4());
			 questionforuser.add(qw);
		 }
		 
		return new ResponseEntity<>(questionforuser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> Test(int id, List<Response> responses) {
		Optional<Quiz> quiz = quizRepository.findById(id);
		List<Question> question = quiz.get().getQuestion();
		int i = 0;
		int right = 0;
		
		for (Response response : responses) {
			
			response.getResponses().equals(question.get(i));
			right++;
		
			i++;
		}
		
		return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}
}
