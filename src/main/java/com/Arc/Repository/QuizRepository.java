package com.Arc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arc.Model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
