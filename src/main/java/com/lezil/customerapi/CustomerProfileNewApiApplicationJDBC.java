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

@SpringBootApplication
public class CustomerProfileNewApiApplicationJDBC implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//This is for Spring JDBC
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileNewApiApplicationJDBC.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//This is for Spring JDBC
		logger.info("****************JDBC***********************************************************");
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
		logger.info("****************JDBC***********************************************************");
		
	}

}
