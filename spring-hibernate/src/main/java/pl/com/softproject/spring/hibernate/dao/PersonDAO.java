package pl.com.softproject.spring.hibernate.dao;
/**
 * Copyright 2015-05-26 the original author or authors.
 */

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.com.softproject.spring.hibernate.model.Person;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface PersonDAO extends CrudRepository<Person, Long> {

    public List<Person> findByLastNameIgnoreCaseLike(String lastName);
    
    @Query("select p from Person p where p.name like :name")
    public List<Person> findByJPQL(@Param("name") String name); 
    
}
