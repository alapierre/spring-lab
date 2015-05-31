package pl.com.softproject.spring.hibernate;
/**
 * Copyright 2015-05-26 the original author or authors.
 */

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pl.com.softproject.spring.hibernate.dao.PersonDAO;
import pl.com.softproject.spring.hibernate.model.Person;

import javax.transaction.Transactional;
import pl.com.softproject.spring.hibernate.dao.AddressDAO;
import pl.com.softproject.spring.hibernate.model.Address;

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
    
    @Autowired
    private AddressDAO addressDAO;

    @Test
    public void test() {
        System.out.println("!");
    }

    @Test
    public void testPreson() {

        Person p = new Person();

        p.setName("Jan");
        p.setLastName("Kowalski");

        System.out.println("id = " + p.getId());
        
        personDAO.save(p);
        
        System.out.println("id = " + p.getId());

    }
    
    @Test
    public void testFind() {
        
        List<Person> res = personDAO.findByLastNameIgnoreCaseLike("Kowalski");
        
        System.out.println(res);
    }
    
    @Test
    public void testFind2() {
        
        List<Person> res = personDAO.findByJPQL("Kowalski");
        
        System.out.println(res);
    }

    @Test
    public void testPersonWithAddress() {
        
        createPersonWithAddress();
        
    }

    protected void createPersonWithAddress() {
        Person p = new Person();
        
        p.setName("Jan");
        p.setLastName("Kowalski");

        Address address = new Address("Lublin", "Racławickie 8", "00-000");
        address.setPerson(p);
        p.getAddresses().add(address);
        
        personDAO.save(p);
    }
    
    @Test
    public void testFindAddress() {
        
        createPersonWithAddress();
        
        List<Address> res = addressDAO.findByPersonId(1L);
        
        System.out.println(res);
        
        
        
    }

}
