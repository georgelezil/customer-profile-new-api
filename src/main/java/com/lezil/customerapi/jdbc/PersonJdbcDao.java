package com.lezil.customerapi.jdbc;

import java.sql.Timestamp;
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

	public Person findById(int id) {
		return (Person) jbbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper(Person.class));

	}

	public int deleteById(int id) {
		return jbbcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int insert(Person person) {
		return jbbcTemplate.update("insert into person (id,name,location,birth_date) values (?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		return jbbcTemplate.update("update person set name = ? ,location = ?, birth_date = ? where id = ?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()
				});
	}

}
