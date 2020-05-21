package com.cg.iter.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.dto.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, BigInteger>{
	
	
	
	

}
