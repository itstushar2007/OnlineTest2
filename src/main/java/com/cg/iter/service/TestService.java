package com.cg.iter.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.iter.dto.Test;

public interface TestService {
	/*
	 * 
	 */
	public Test addTest(Test test);
	public ResponseEntity<Test> updateTest(Test test);
	public String deleteTest(BigInteger testId);
	public List<Test> getAllTest();
	public ResponseEntity<Test> getTestById( BigInteger testId);
	public BigDecimal calculateTotalMarks(BigInteger testId);
	//public String assignTest(Long userId,BigInteger testId);
	//public BigDecimal getResult(Test test);
	//public String giveTest(BigInteger testId);

}
