/*package com.lezil.customerapi;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lezil.customerapi.entity.Person;
import com.lezil.customerapi.jdbc.PersonJdbcDao;
import com.lezil.customerapi.jpa.PersonJpaRepository;


@SpringBootApplication
public class CustomerProfileNewApiApplicationJPA implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//This is for JPA
	@Autowired
	PersonJpaRepository dao;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileNewApiApplicationJPA.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		logger.info("****************JPA***********************************************************");
		//Find by Id
		logger.info("Find by id 	: " + dao.findById(10001));
		//Insert
		logger.info("Insert  		: ", dao.insert(new Person(10005,"JPA1","JP1LAST", new Date())));
		//Update
		logger.info("Update by id	: ", dao.insert(new Person(10001,"JPA2","JP2LAST", new Date())));
		//Delete
		dao.deleteById(10002);
		//Find All
		logger.info("Find all person : " + dao.findAll());
		logger.info("****************JPA***********************************************************");
		
	}

}

*/