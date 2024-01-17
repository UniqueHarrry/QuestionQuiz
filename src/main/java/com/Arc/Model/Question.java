package com.Arc.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "question_")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String questions;
	private String category;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questionLevel;
	private String answer;
}
