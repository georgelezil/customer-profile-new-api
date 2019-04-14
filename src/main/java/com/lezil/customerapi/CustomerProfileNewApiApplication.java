package com.lezil.customerapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lezil.customerapi.entity.Person;
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
		Person person =  personJdbcDao.findById(10001);
		logger.info("Find by id : " + personJdbcDao.findById(10001));
		logger.info("Delete by id : ");
		logger.info("Delete row by id : ", personJdbcDao.deleteById(10001));
		person.setId(10004);
		logger.info("Insert row by id : ", personJdbcDao.insert(person));
		
		person =  personJdbcDao.findById(10004);
		person.setName("Test Update");
		logger.info("Update row by id : ", personJdbcDao.update(person));
		
	}

}
