package com.sunsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.sunsoft.controller","com.sunsoft.dao","com.sunsoft.model","com.sunsoft.repository"})
public class InsuranceDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceDomainApplication.class, args);
	}

}
