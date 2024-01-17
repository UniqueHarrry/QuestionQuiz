package com.Arc.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Arc.Model.Question;
import com.Arc.Repository.QuestionRepository;

@Service
public class QuestionSerivce {

	@Autowired
	private QuestionRepository questionRepo;

	public ResponseEntity<Question> SaveQuestion(Question theQuestions) {
	try {
		return new ResponseEntity<>(questionRepo.save(theQuestions), HttpStatus.CREATED);
	}
	catch (Exception e) {
		System.out.println("Not Saved...");
	}	
	return  new ResponseEntity<>(questionRepo.save(theQuestions), HttpStatus.BAD_GATEWAY);
	}

	
	
	public ResponseEntity<Question> GetQuestion(String Category) {
		try {
		return new ResponseEntity<>(questionRepo.findByCategory(Category), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			System.out.println("Please Select Different Category");
		}
		
		return new ResponseEntity<>(questionRepo.findByCategory(Category), HttpStatus.BAD_REQUEST);
		}

	public ResponseEntity<List<Question>> GetAllQuestion() {
		try {
		return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Error...");
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}

	public Question Update(Question theQuestions) {
		return questionRepo.save(theQuestions);
		}

	public ResponseEntity<String> DeleteQuestion(int id) {
		 
		try {
			questionRepo.deleteById(id);
		} catch (Exception e) {
			System.out.println("Error...");
		}
		return new ResponseEntity<>("Sucessfully Deleted...", HttpStatus.OK);
		}

	 }
