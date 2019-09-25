package com.springbootCRUD.springbootrestapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudPortFolio {

	public static void main( String []args) {
		SpringApplication.run(CrudPortFolio.class, args);
		
	}
	
	
	
}
