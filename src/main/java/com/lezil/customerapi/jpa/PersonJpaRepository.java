package com.lezil.customerapi.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.lezil.customerapi.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	
	@PersistenceContext
	EntityManager entityManager; //Manages the Entity
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);

	}

	
}
