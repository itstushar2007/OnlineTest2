package com.cg.iter.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.iter.dto.Admin;

public interface AdminService {

	Admin addAdmin(Admin admin);

	String updateAdmin(BigInteger adminId, Admin adminDetails);

	String deleteAdmin(BigInteger adminId);

	ResponseEntity<Admin> getAdminById(BigInteger adminId);

	List<Admin> getAllAdmin();

	BigInteger checkAdminLogin(String loginName, String password);
	
	

}
