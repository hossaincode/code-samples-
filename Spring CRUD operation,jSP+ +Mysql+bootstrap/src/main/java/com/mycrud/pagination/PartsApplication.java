package com.mycrud.pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PartsApplication {
	
	
	
	public static void main(String []args)
	{
		SpringApplication.run(PartsApplication.class, args);
		
		
	}

}
