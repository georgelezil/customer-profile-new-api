package com.lezil.customerapi.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lezil.customerapi.entity.Person;

@Repository	
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jbbcTemplate;
	
	public List<Person> findAll() {
		return jbbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
		
	}
}
