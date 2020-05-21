package com.cg.iter.dto;


import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger studentId;
	private String studentName;
	private String studentPassword;
	
	
	private BigInteger testId;
	
	
	public BigInteger getTestId() {
		return testId;
	}
	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}
	public BigInteger getStudentId() {
		return studentId;
	}
	public void setStudentId(BigInteger studentId) {
		studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		studentName = studentName;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	public Student()
	{
		//non-parameterized constructor.
	}
	
	
	public Student(BigInteger studentId, String studentName, String studentPassword) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
	}
	@Override
	public String toString() {
		return "Student [StudentId=" + studentId + ", StudentName=" + studentName + ", studentPassword="
				+ studentPassword + "]";
	}
	
	
}


























//
//import java.math.BigInteger;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name= "user_table")
//public class Student {
//	
//	@Id
//	private Long userid;
//	private String username;
//	
//	@OneToOne
//	@JoinColumn(name= "testId")
//	private Test userTest;
//	
//	private Boolean isAdmin;
//	private String userpassword;
//	private BigInteger testIds;
//	
//	public BigInteger getTest_id() {
//		return testIds;
//	}
//
//	public void setTest_id(BigInteger test_ids) {
//		this.testIds = test_ids;
//	}
//
//	public Student() {
//		
//	}
//
//	public Student(Long userid, String username, Test useTest, Boolean isAdmin, String userpassword, BigInteger test_ids) {
//		super();
//		this.userid = userid;
//		this.username = username;
//		this.userTest = useTest;
//		this.isAdmin = isAdmin;
//		this.userpassword = userpassword;
//		this.testIds = test_ids;
//	}
//
//	public Long getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public Test getUserTest() {
//		return userTest;
//	}
//
//	public void setUserTest(Test userTest) {
//		this.userTest = userTest;
//	}
//
//	public Boolean getIsAdmin() {
//		return isAdmin;
//	}
//
//	public void setIsAdmin(Boolean isAdmin) {
//		this.isAdmin = isAdmin;
//	}
//
//	public String getUserpassword() {
//		return userpassword;
//	}
//
//	public void setUserpassword(String userpassword) {
//		this.userpassword = userpassword;
//	}
//
//	@Override
//	public String toString() {
//		return "User [userid=" + userid + ", username=" + username + ", useTest=" + userTest + ", isAdmin=" + isAdmin
//				+ ", userpassword=" + userpassword + "]";
//	}
//	
//	
//	
//	
//	
//	
//
//}
