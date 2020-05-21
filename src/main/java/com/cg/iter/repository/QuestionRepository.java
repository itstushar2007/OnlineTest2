package com.cg.iter.repository;

import java.math.BigInteger;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.iter.dto.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, BigInteger> {
	
	
	@Query(value="select * from questions where test_id=:id",nativeQuery = true)
	public Question[] findQuestionByTestId(@Param("id")BigInteger id);
	
	
	
//	@Query(value="select * from question_table where testId=:id",nativeQuery = true)
//	public Question[] findQuesById(BigInteger id);
//	

}
