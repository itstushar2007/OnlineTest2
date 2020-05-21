package com.cg.iter.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.dto.Test;
import com.cg.iter.dto.Student;

public interface StudentService {

	Student addStudent(Student std);

	ResponseEntity<Student> updateStudent(Student studentDetails);

	String deleteStudent(BigInteger stdId);

	ResponseEntity<Student> getStudentById(BigInteger stdId);

	List<Student> getAllStudent(BigInteger stdId);

	BigInteger getTestByStudentId(BigInteger studentId);

	BigInteger checkLogin(String loginName, String password);

	String assignTest(BigInteger stdId, BigInteger testId);

//	ResponseEntity<Test> updateTest(Test test);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Student addUser(Student student);
//	public Student updateUser(@Valid @RequestBody Student student);
//	public String deleteUser(Long userid);
//	public List<Student> getAllUser(Long  userid);
//    public Optional<Student> getUSerById( Long userid);
//	public BigInteger checkLogin(String  username,String password);
//	public Long getTestByUserId(Long userid);
//	public String assignTest(Long userid,BigInteger testid);
//	public ResponseEntity<Test> updateTest(Test test);

}
