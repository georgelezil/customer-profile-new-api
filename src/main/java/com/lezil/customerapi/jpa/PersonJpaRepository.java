package com.lezil.customerapi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lezil.customerapi.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	
	@PersistenceContext
	EntityManager entityManager; //Manages the Entity
	
	
	//JPQL - java persistance query language
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();		

	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);

	}
	
	public Person update(Person person) {
		return entityManager.merge(person);

	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);

	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);

	}
	
}
