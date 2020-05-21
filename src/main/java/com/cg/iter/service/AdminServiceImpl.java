package com.cg.iter.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.dto.Admin;
import com.cg.iter.repository.AdminRepository;

@Service
public class AdminServiceImpl {
	

	@Autowired
	AdminRepository adminrepo;

	
	//add Admin
	public Admin addAdmin(Admin admin)
	{
		return adminrepo.save(admin);
	}
	
	//show Admin
	public List<Admin> getAllAdmin() 
	{
		
		return (List<Admin>) adminrepo.findAll();
	}
	
	 
	 
	//Update Admin	
		 public String updateAdmin( BigInteger adminId,  Admin adminDetails)
		    		//throws RecordNotFoundException 
		 {
		    	Optional<Admin> admin = adminrepo.findById(adminId);
		    	adminrepo.save(adminDetails);
		    //	orElseThrow(() -> new RecordNotFoundException("Admin not found for the give id " +adminId));
		             
		    	return "Admin Updated Successfully...";
		    }

		 
// get admin By Id
	public Optional<Admin> getAdminById( BigInteger adminId) //throws RecordNotFoundException 
	{
	Optional<Admin> admin=adminrepo.findById(adminId);
		   //orElseThrow(() -> new RecordNotFoundException("Admin not found for the given id" +adminId));
		    return admin;
		 }
	
		
	
	
	//login
	public BigInteger checkAdminLogin(String loginName,String password) 
	{
	Optional<BigInteger> findById=adminrepo.checkAdminLogin(loginName,password);
	if(findById.isPresent()) 
	{
		BigInteger id=findById.get();
			return id;
	}
	else 
		return null;
	}
		 
		 
	//delete admin
	public String deleteAdmin(BigInteger adminId) {
		
	Optional<Admin> findById = adminrepo.findById(adminId);
	if (findById.isPresent())
	{
		adminrepo.deleteById(adminId);
			return "deleted";
	}
	else
	{
		return "!!   Id Is Invalid   !!";
	}
		    
	}

}
