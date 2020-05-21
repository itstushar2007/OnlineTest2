package com.cg.iter.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@EntityScan(basePackages = {"com.cg.iter.dto"} )
@EnableJpaRepositories(basePackages = {"com.cg.iter.repository"})
@SpringBootApplication
public class OnlineTestManagementApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(OnlineTestManagementApplication.class, args);
		//SpringApplication.run(OnlineTestManagementApplication.class, args);
		//ConfigurableApplicationContext ctx = 
	
	}

}
