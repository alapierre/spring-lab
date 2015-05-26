package pl.com.softproject.spring.hibernate.dao;
/**
 * Copyright 2015-05-26 the original author or authors.
 */

import org.springframework.data.repository.CrudRepository;

import pl.com.softproject.spring.hibernate.model.Person;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface PersonDAO extends CrudRepository<Person, Long> {

}
