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

	@RequestMapping(method=RequestMethod.GET, value="/hello")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("" + new Date(), HttpStatus.OK);
	}

	/* Best way */
	@RequestMapping("/person/{id}")
	public ResponseEntity<Person> getPersonDetails(@PathVariable int id) throws PersonNotFoundException {

		Person person = null;
		person = dao.findById(id);
		if (person == null) {
			throw new PersonNotFoundException("No person found");
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping("/person")
	public ResponseEntity<Person> getPersonDetailsWithRequestParam(@RequestParam(value = "id", defaultValue = "10001") int id) throws PersonNotFoundException {

		Person person = null;
		person = dao.findById(id);
		if (person == null) {
			throw new PersonNotFoundException("No person found");
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAllPerson() throws PersonNotFoundException {

		List<Person> personlst = dao.findAll();
		if (personlst != null && personlst.size() == 0) {
			throw new PersonNotFoundException("No persons found");
		}
		return new ResponseEntity<List<Person>>(personlst, HttpStatus.OK);

	}

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	/* Best way End */



}
