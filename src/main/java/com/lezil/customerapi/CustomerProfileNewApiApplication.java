package com.lezil.customerapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lezil.customerapi.jdbc.PersonJdbcDao;

@SpringBootApplication
public class CustomerProfileNewApiApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileNewApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All person : " + personJdbcDao.findAll());
		
	}

}
