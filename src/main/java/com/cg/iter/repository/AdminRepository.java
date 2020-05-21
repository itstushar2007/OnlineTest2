package com.cg.iter.repository;

import java.math.BigInteger;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.dto.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, BigInteger> {
	
	
	
	@Query(value="select admin_id from admin where admin_name=:name and admin_password=:password",nativeQuery = true)
	public Optional<BigInteger> checkAdminLogin(String name,String password);



	

}
