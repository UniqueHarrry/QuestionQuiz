package com.Arc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Arc.Model.Question;


public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Question findByCategory(String Category);

	 
    @Query(value = "SELECT * FROM question_ q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)

	List<Question> findRandomQuestionsByCategory( String category, int numQ);


}
