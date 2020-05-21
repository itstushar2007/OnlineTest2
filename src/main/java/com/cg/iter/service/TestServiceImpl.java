package com.cg.iter.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.dto.Test;
import com.cg.iter.exception.RecordNotFoundException;
import com.cg.iter.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {
	
	
		
		@Autowired
		private TestRepository testrepo;
		

	//add Test
		@Override
		public Test addTest(Test test)
		   {
			  return testrepo.save(test);
			   
		   }
			
	//update Test
		@Override
		public ResponseEntity<Test> updateTest( @RequestBody Test test)
			{
				Optional<Test> findById=testrepo.findById(test.getTestId());
				try {
				if(findById.isPresent())
				{
					 testrepo.save(test);
					 return new ResponseEntity<Test>(test,HttpStatus.OK);		
				}
				else {
					throw new RecordNotFoundException("Record not present");
					}
				}
				catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
				
				}
			}
			
		 
	//Delete test	
		@Override
		 public String deleteTest(BigInteger testId) throws RecordNotFoundException
		    {
		    	 testrepo.findById(testId).
		    	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +testId));
		    	testrepo.deleteById(testId);
		    	return "Test Deleted Successfully...";
		    }
		 
	//get All Test
		@Override
		 public List<Test> getAllTest(){
		    	
			    System.out.println("All Tests are:");
		    	return (List<Test>) testrepo.findAll();
		    	
		    }

	//get Test By Id
		@Override
		 public ResponseEntity<Test> getTestById( BigInteger testId) throws RecordNotFoundException {
			 Test test=testrepo.findById(testId).
		   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +testId));
		    	return ResponseEntity.ok().body(test);
		    }
		 
		 
	//calculate Marks
        @Override
		public BigDecimal calculateTotalMarks(BigInteger testId) throws RecordNotFoundException{
			 testrepo.findById(testId).
	    	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +testId));
	    	QuestionServiceImpl qimpl=new QuestionServiceImpl();
	    	Test test= new Test();
	    	
	    	test.setTestMarksScored(BigDecimal.valueOf(qimpl.calculateQuestionMarks(testId)));
	   
	           return test.getTestMarksScored();
		 }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Autowired
//	TestRepository testrepository;
//	@Autowired
//	QuestionRepository questionrepository;
//	@Autowired
//	StudentRepository userrepository;
//	
//	@Override
//	public Test addTest(Test test) {
//		
//		return testrepository.save(test);
//		
//	}
//	
//
//	@Override
//	public Test updateTest(Test test) {
//		
//		Optional<Test> find= testrepository.findById(test.getTestId());
//		if(find.isPresent())
//		{
//			return  testrepository.save(test);
//		}
//		else return null;
//		
//	}
//	
//
//	@Override
//	public String deleteTest(BigInteger testId) {
//		
//		Optional<Test> find = testrepository.findById(testId);
//		if(find.isPresent())
//		{
//			testrepository.deleteById(testId);
//			return "Test Deleted ...." ;
//		}
//		else return "Invalid test Id";
//	}
//	
//	@Override
//	public List<Test> getAllTest(BigInteger testId) {
//		
//		return (List<Test>) testrepository.findAll();
//		
//	}
//	
//	@Override
//	public Optional<Test> getTestById(BigInteger testId) {
//		
//		return testrepository.findById(testId);
//		
//	}
//
//	
//	@Override
//	public BigDecimal calculateTotalMarks(BigInteger testId) {
//		
//		testrepository.findById(testId);
//		QuestionServiceImpl service = new QuestionServiceImpl();
//		Test test = new Test();
//		
//		 test.setTestTotalMarks(service.calculateQuestionMarks(testId));
//		 
//		 return test.getTestTotalMarks();
//		 
//	}

//
//	@Override
//	public String assignTest(Long userId, BigInteger testId)
//	{
//		Optional<User> find = userrepository.findById(userId);
//		Optional<Test> find1 = testrepository.findById(testId);
//		if(find.isPresent() && find1.isPresent())
//		{
//			User user = find.get();
//			user.setTest_id(testId);
//			userrepository.save(user);
//			return "Test Assigned Successfully..." ;
//			
//		}
//		else return "User or Test does not exist";
//	}


//	@Override
//	public BigDecimal getResult(Test test)
//	{
//		Optional<Test> find = testrepository.findById(test.getTestId());
//		if(find.isPresent()) {
//			
//			return test.getTestMarksScored();
//			
//		}else return null;
//	
//	}	

	

//
//	@Override
//	public String giveTest(BigInteger testId) {
//		
//		
//	}
	
	
			
			
		
		
//		BigDecimal tmarks = new BigDecimal("0.0");
//		List<Question> list = (List<Question>) questionrepository.findAll();
//		for(Question ques:list)
//		{
//			tmarks= tmarks.add(ques.getMarksScored());
//		}
//		
//		
//		return tmarks;
	


	


	








	
	

		
