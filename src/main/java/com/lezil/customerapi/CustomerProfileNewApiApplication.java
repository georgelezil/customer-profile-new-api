package com.lezil.customerapi;

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
public class CustomerProfileNewApiApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//This is for Spring JDBC
	/*@Autowired
	PersonJdbcDao dao;*/
	
	
	//This is for JPA
	@Autowired
	PersonJpaRepository dao;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileNewApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		//This is for Spring JDBC
		/*
		logger.info("All person : " + dao.findAll());
		Person person =  dao.findById(10001);
		logger.info("Find by id : " + dao.findById(10001));
		logger.info("Delete by id : ");
		logger.info("Delete row by id : ", dao.deleteById(10001));
		person.setId(10004);
		logger.info("Insert row by id : ", dao.insert(person));
			
		person =  dao.findById(10004);
		person.setName("Test Update");
		logger.info("Update row by id : ", dao.update(person));
		logger.info("All person : " + dao.findAllUsingRowMapper());
		*/
		
		
		
		logger.info("Find by id : " + dao.findById(10001));
		//Insert
		logger.info("Insert  : ", dao.insert(new Person(10005,"JPA1","JP1LAST", new Date())));
		//Update
		logger.info("Update by id : ", dao.insert(new Person(10001,"JPA2","JP2LAST", new Date())));
		
		dao.deleteById(10002);
		
		logger.info("jpa All person : " + dao.findAll());
		
		
	}

}
