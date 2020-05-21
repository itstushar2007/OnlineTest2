package com.cg.iter.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.iter.dto.Question;

public interface QuestionService {
	
	//public void saveQuestion(Question q);
//	public Question addQuestion(BigInteger testId,Question question);
//	public String deleteQuestion(BigInteger qid);
//	public String updateQuestion(BigInteger testId,Question question);
//	public List<Question> findAllQuestions();
//	public ResponseEntity<Question[]> findQuesById(BigInteger id);
//	public BigDecimal calculateQuestionMarks(BigInteger id);
	public ResponseEntity<Question[]> getQuestionById(BigInteger tid);

	public String updateQuestion(BigInteger testId, Question questionDetails);

	public String deleteQuestion(BigInteger questionId);

	public List<Question> viewAll();

	public Question addQuestion(BigInteger testId, Question question);


}
