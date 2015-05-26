package pl.com.softproject.spring.hibernate;
/**
 * Copyright 2015-05-26 the original author or authors.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pl.com.softproject.spring.hibernate.dao.PersonDAO;
import pl.com.softproject.spring.hibernate.model.Person;

import javax.transaction.Transactional;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-hibernate-core.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class SpringContext {

    @Autowired
    private PersonDAO personDAO;

    @Test
    public void test() {
        System.out.println("!");
    }

    @Test
    public void testPreson() {

        Person p = new Person();

        p.setName("Jan");
        p.setLastName("Kowalski");

        personDAO.save(p);

    }


}
