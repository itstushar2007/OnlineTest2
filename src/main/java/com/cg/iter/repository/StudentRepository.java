package com.cg.iter.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.cg.iter.dto.Student;


public interface StudentRepository extends CrudRepository<Student, BigInteger> {
	
	
	@Query(value="select student_id from student where student_name=:name and student_password=:password",nativeQuery = true)
	public Optional<BigInteger> checkLogin(String name,String password);
	
	@Query(value="select test_id from student where student_id=:studentId",nativeQuery = true)
	public BigInteger getTestByStudentId(@Param("studentId")BigInteger studentId);
	
	
	
//	@Query(value="select user_id from student where user_name=:username and user_password=:password",nativeQuery = true)
//	public Optional<BigInteger> checkLogin(String username,String password);
//	
//	@Query(value="select test_id from student where user_id=:userid",nativeQuery = true)
//	public BigInteger getTestByUserId(@Param("userid")BigInteger studentId);
	
	

}
