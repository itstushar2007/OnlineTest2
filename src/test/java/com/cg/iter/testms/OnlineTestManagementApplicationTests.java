package com.cg.iter.testms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalTime;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.dto.Student;


@SpringBootTest
class OnlineTestManagementApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	  static Logger logger=LoggerFactory.getLogger(OnlineTestManagementApplicationTests.class);
		 
		
		RestTemplate template;
		
		@BeforeEach
		public void setUp()
		{
			template=new RestTemplate();		
		}
		
		@Test
		public void addStudent() {
			Student student= new Student();
			student.setStudentId(new BigInteger("123"));
			student.setStudentName("Raman Jha");
			student.setStudentPassword("Jha*87");
			//student.setTestId(BigInteger.valueOf(1002));
			
			try {
				ResponseEntity<Student> postForEntity=template.postForEntity("http://uplc:9595/Student/addStudent",
						student, Student.class);
				Assertions.assertNotNull(postForEntity);
				
		
			logger.info("add student works "+postForEntity.getStatusCodeValue());
				
			}
			catch(HttpClientErrorException e) {
				Assertions.fail(e.getMessage());
			}
		}
		
	

	
}

