package com.lezil.customerapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezil.customerapi.entity.Person;
import com.lezil.customerapi.jpa.PersonJpaRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	PersonJpaRepository dao;
	
	@RequestMapping("/hello")
	public String home() {
		return "" + new Date() ;
	}
	
	@RequestMapping("/person")
	public Person getPersonDetails(@RequestParam(value="id", defaultValue="World") int id) {
		return dao.findById(id);
	}
	
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
