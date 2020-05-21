package com.cg.iter.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.dto.Student;
import com.cg.iter.dto.Test;
import com.cg.iter.exception.RecordNotFoundException;
import com.cg.iter.repository.StudentRepository;
import com.cg.iter.repository.TestRepository;



public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentrepo;
	@Autowired
	private TestRepository testrepo;
	
	
	
//This service API will be called when a student wants to add himself.
	@Override
	public Student addStudent(Student std)
	   {
		   return  studentrepo.save(std);		   
	   }
	 
	 
//This API will update the details(name and password) of the student. 	
	@Override
	    public ResponseEntity<Student> updateStudent( @RequestBody Student std)
			{
				Optional<Student> findById=studentrepo.findById(std.getStudentId());
				try {
				if(findById.isPresent())
				{
					 studentrepo.save(std);
					 return new ResponseEntity<Student>(std,HttpStatus.OK);		
				}
				else {
					throw new RecordNotFoundException("Record not present");
					}
				}
				catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
				
			}
		}
		
			
//This API will delete the student details from the students list. 	
	@Override
	 public String deleteStudent(BigInteger stdId) throws RecordNotFoundException
	    {
		 Optional<Student> findById = studentrepo.findById(stdId);
			if (findById.isPresent()) {
				studentrepo.deleteById(stdId);
				return "deleted";
			} else {
				return "!!   Id Is Invalid   !!";
			}
	    }
	 
	 
//Below API will be called to get the lists of all students.
	@Override
	 public List<Student> getAllStudent(BigInteger stdId){
	    	
		    
	    	return (List<Student>) studentrepo.findAll();   	
	    }
	 

//This API will be used to get student details  by his student Id.
	@Override
	 public ResponseEntity<Student> getStudentById( BigInteger stdId) throws RecordNotFoundException {
	    	Student stdStudent=studentrepo.findById(stdId).
	   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +stdId));
	    	return ResponseEntity.ok().body(stdStudent);
	    }
	 
	 
//This API will be used at the time of Student login
	@Override
	 public BigInteger checkLogin(String loginName,String password) {
		 Optional<BigInteger> findById=studentrepo.checkLogin(loginName,password);
		 if(findById.isPresent()) {
			 BigInteger id=findById.get();
			 return id;
		 }
		 else return null;
	 }
	 
//This API will get the test assigned to the student using his student id.
	 @Override
		public BigInteger getTestByStudentId(BigInteger studentId)
				throws RecordNotFoundException {

			BigInteger id1= studentrepo.getTestByStudentId(studentId);
			return id1;
		}

	 
//For assigning test to the student this API will be called.
	 @Override
	 public String assignTest(BigInteger studentId,BigInteger testId)
		{
			Optional<Student>findById=studentrepo.findById(studentId);
			Optional<Test>test=testrepo.findById(testId);
			if(findById.isPresent()&& test.isPresent())
			{
				Student student=findById.get();
				student.setTestId(testId);
				studentrepo.save(student);
				return "Test Assigned";
				
			}
			return "User or Test does not exist";
			
		}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	UserRepository userrepository;
//	@Autowired
//	TestRepository testrepository;
//	
//	//Add User
//	    @Override
//		public Student addUser(Student student)
//		   {
//			   return  userrepository.save(student);		   
//		   }
//		 
//		 
//	//Update User	
//		    @Override
//			public Student updateUser(@Valid @RequestBody Student student)
//				{
//					Optional<Student> findById=userrepository.findById(student.getUserid());
//					
//					if(findById.isPresent())
//					{
//						
//						 return  userrepository.save(student); 	
//					}
//					else
//						{return null;}
////					else {
////						throw new RecordNotFoundException("Record not present");
////						}
////					}
////					catch(RecordNotFoundException e) {
////					return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
////					
////				}
//					}
//			
//				
//	//Delete User	 
//		 @Override
//		 public String deleteUser(Long userid) //throws RecordNotFoundException
//		    {
//			 Optional<Student> findById = userrepository.findById(userid);
//				if (findById.isPresent()) {
//					userrepository.deleteById(userid);
//					return "deleted";
//				} else {
//					return "!!   Id Is Invalid   !!";
//				}
//		    }
//		 
//		 
//	//Get All User
//		 @Override
//		 public List<Student> getAllUser(Long  userid){
//		    	
//			    System.out.println("All Students are:");
//		    	return (List<Student>) userrepository.findAll();  	
//		    }
//		 
//
//	//Get User By Id
//		 @Override
//		 public Optional<Student> getUSerById( Long userid)  //throws RecordNotFoundException
//		 {
//		    	Optional<Student> student=userrepository.findById(userid);
//		    	return student;
//		    	
////		   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +userid));
////		    	return ResponseEntity.ok().body(user);
//		    
//		 }
//		 
//		 
//		//login	
//		 @Override
//		 public BigInteger checkLogin(String  username,String password)
//		 {
//	   
//			 Optional<BigInteger> findById=userrepository.checkLogin(username, password);
//					 if(findById.isPresent()) {
//				 BigInteger id=findById.get();
//				 return id;
//			 }
//			 else return null;
//		 }
//		 
//		 
//		 //getTestByUserId
//		 @Override
//			public Long getTestByUserId(Long userid)  //throws RecordNotFoundException
//			{
//
//				Long id1= userrepository.getTestByUserId(userid);
//						return id1;
//			}
//
//		 
//	    //AssignTest
//		 @Override
//		 public String assignTest(Long userid,BigInteger testid)
//			{
//				Optional<Student>findById=userrepository.findById(userid);
//				Optional<Test>test=testrepository.findById(testid);
//				if(findById.isPresent()&& test.isPresent())
//				{
//					Student student=findById.get();
//					student.setTest_id(testid);
//					userrepository.save(student);
//					return "Test Assigned";
//					
//				}
//				return "User or Test does not exist";
//				
//			}
//
//}
