package com.lezil.customerapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezil.customerapi.custom.exception.ErrorResponse;
import com.lezil.customerapi.custom.exception.PersonNotFoundException;
import com.lezil.customerapi.entity.Person;
import com.lezil.customerapi.jpa.PersonJpaRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	PersonJpaRepository dao;
	
	@GetMapping("/hello")
	public String home() {
		return "" + new Date() ;
	}
	
	//ResponseEntity  class takes two arguments, one is the returning object itself and other the status code. 
	//But this adds more code into the controller method and makes it complex with all try catch blocks.
	/*
	@RequestMapping("/person/{id}")
	public ResponseEntity<Person> getPersonDetails(@PathVariable int id) {
		
		Person person = null;
		try {
			person =  dao.findById(id);
		}catch(Exception  e){
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	*/
	
	
	/* Best way*/
	@RequestMapping("/person/{id}")
	public ResponseEntity<Person> getPersonDetails_new(@PathVariable int id) throws PersonNotFoundException {
		
		Person person = null;
		person =  dao.findById(id);
		if(person == null){
			throw new PersonNotFoundException("No person found");
		}
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
	
	/*Best way End*/
	
	/*
	@RequestMapping("/person1/{id}")
	public Person getPersonDetails1(@PathVariable int id) {
		return dao.findById(id);
	}

	
	@RequestMapping("/person2")
	public Person getPersonDetails2(@RequestParam(value="id", defaultValue="0") int id) {
		return dao.findById(id);
	}
	
	@GetMapping("/person3")
	public Person getPersonDetails3(@RequestParam(value="id", defaultValue="0") int id) {
		return dao.findById(id);
	}
	*/
	
	@RequestMapping(method=RequestMethod.GET, value="/persons")
	public List<Person> getAllPerson() {
		return dao.findAll();
	}
	
	@GetMapping("/persons1")
	public List<Person> getAllPerson1() {
		return dao.findAll();
	}
	
	
	
	//public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	//	return new Greeting(counter.incrementAndGet(),
	//              String.format(template, name));
	//}

	
	

}
