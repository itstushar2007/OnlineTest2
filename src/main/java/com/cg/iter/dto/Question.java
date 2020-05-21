package com.cg.iter.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name= "question_table")
public class Question {
	@Id
	private BigInteger questionId;
	
	@OneToMany(targetEntity = Answer.class,cascade= CascadeType.ALL, mappedBy="question")
	@JsonManagedReference
	private List<Answer> questionOptions;
	
	
	private String questionTitle;
	private int questionAnswer;
	private int questionMarks;
	private int chosenAnswer;
	private BigDecimal marksScored;
	@ManyToOne
	//@JoinColumn(name="testId")
	@JsonBackReference//(targetEntity = Test.class,cascade = CascadeType.PERSIST)
	private Test test;
	
	public Question() {}

	public Question(BigInteger questionId, List<Answer> questionOptions, String questionTitle,
			Integer questionAnswer, int questionMarks, Integer chosenAnswer, BigDecimal marksScored) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	
	}
	
//
//	public Question(BigInteger questionId, String questionTitle, Integer questionAnswer, int questionMarks,
//			Integer chosenAnswer, BigDecimal marksScored) {
//		super();
//		this.questionId = questionId;
//		this.questionTitle = questionTitle;
//		this.questionAnswer = questionAnswer;
//		this.questionMarks = questionMarks;
//		this.chosenAnswer = chosenAnswer;
//		this.marksScored = marksScored;
//	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionOptions=" + questionOptions + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks=" + questionMarks
				+ ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + "]";
	}

	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public BigInteger getQuestionId() {
		return questionId;
	}

	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}

	public List<Answer> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<Answer> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Integer getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	public Integer getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(Integer chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public BigDecimal getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}
	
	

}
