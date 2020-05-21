package com.cg.iter.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name= "test_table")
public class Test {
	
	@NotNull(message="id is blank")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger testId;
	
	@NotEmpty(message="test title is blank")
	private String testTitle;
	private LocalTime testDuration;
	
	@OneToMany(targetEntity=Question.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="test")
	@JsonManagedReference
	private Set<Question> testQuestions;
	
	
	private BigDecimal testTotalMarks;
	private BigDecimal testMarksScored;
	@Transient
	private Question currentQuestion;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
//	@OneToOne(mappedBy="studentTest",cascade = CascadeType.ALL)
//	private Student studentId;
	@OneToOne
	private Student studentId;
	
	


	public Student getStudentId() {
		return studentId;
	}



	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}



	public Test() {}

	public Test(BigInteger testId, String testTitle, LocalTime testDuration, Set<Question> testQuestions,
			BigDecimal testTotalMarks, BigDecimal testMarksScored, LocalDateTime startTime, LocalDateTime endTime,
			Student studentId, Question currentQuestion) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
		this.studentId = studentId;
		this.currentQuestion = currentQuestion;
	}
	public BigInteger getTestId() {
		return testId;
	}
	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}
	
	public Set<Question> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public BigDecimal getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(BigDecimal testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
	@Override
	public String toString() {
		return "Assessment [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testQuestions=" + testQuestions + ", testTotalMarks=" + testTotalMarks + ", testMarksScored="
				+ testMarksScored + ", startTime=" + startTime + ", endTime=" + endTime + ", studentId=" + studentId
				+ ", currentQuestion=" + currentQuestion + "]";
	}	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//
//	public Test(BigInteger testId, String testTitle, LocalTime testDuration, Set<Question> testQuestions,
//			BigDecimal testTotalMarks, BigDecimal testMarksScored, Question currentQuestion, LocalDateTime startTime,
//			LocalDateTime endTime) {
//		super();
//		this.testId = testId;
//		this.testTitle = testTitle;
//		this.testDuration = testDuration;
//		this.testQuestions = testQuestions;
//		this.testTotalMarks = testTotalMarks;
//		this.testMarksScored = testMarksScored;
//		this.currentQuestion = currentQuestion;
//		this.startTime = startTime;
//		this.endTime = endTime;
//	}
//	
//
//
//
//	public Test(BigInteger testId, String testTitle, LocalTime testDuration, BigDecimal testTotalMarks,
//			BigDecimal testMarksScored, Question currentQuestion, LocalDateTime startTime, LocalDateTime endTime,
//			Student studentId) {
//		super();
//		this.testId = testId;
//		this.testTitle = testTitle;
//		this.testDuration = testDuration;
//		this.testTotalMarks = testTotalMarks;
//		this.testMarksScored = testMarksScored;
//		this.currentQuestion = currentQuestion;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.studentId = studentId;
//	}

//	public BigInteger getTestId() {
//		return testId;
//	}
//
//	public void setTestId(BigInteger testId) {
//		this.testId = testId;
//	}
//
//	public String getTestTitle() {
//		return testTitle;
//	}
//
//	public void setTestTitle(String testTitle) {
//		this.testTitle = testTitle;
//	}
//
//	public LocalTime getTestDuration() {
//		return testDuration;
//	}
//
//	public void setTestDuration(LocalTime testDuration) {
//		this.testDuration = testDuration;
//	}
//
//	public Set<Question> getTestQuestions() {
//		return testQuestions;
//	}
//
//	public void setTestQuestions(Set<Question> testQuestions) {
//		this.testQuestions = testQuestions;
//	}
//
//	public BigDecimal getTestTotalMarks() {
//		return testTotalMarks;
//	}
//
//	public void setTestTotalMarks(BigDecimal testTotalMarks) {
//		this.testTotalMarks = testTotalMarks;
//	}
//
//	public BigDecimal getTestMarksScored() {
//		return testMarksScored;
//	}
//
//	public void setTestMarksScored(BigDecimal testMarksScored) {
//		this.testMarksScored = testMarksScored;
//	}
//
//	public Question getCurrentQuestion() {
//		return currentQuestion;
//	}
//
//	public void setCurrentQuestion(Question currentQuestion) {
//		this.currentQuestion = currentQuestion;
//	}
//
//	public LocalDateTime getStartTime() {
//		return startTime;
//	}
//
//	public void setStartTime(LocalDateTime startTime) {
//		this.startTime = startTime;
//	}
//
//	public LocalDateTime getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(LocalDateTime endTime) {
//		this.endTime = endTime;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
//				+ ", testQuestions=" + testQuestions + ", testTotalMarks=" + testTotalMarks + ", testMarksScored="
//				+ testMarksScored + ", currentQuestion=" + currentQuestion + ", startTime=" + startTime + ", endTime="
//				+ endTime + "]";
//	}
	
	
	
	

}
