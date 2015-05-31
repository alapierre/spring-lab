/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.jdbc.dao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.softproject.spring.jdbc.model.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 *
 * @author CSI
 */
@ContextConfiguration("/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDAOJdbcImplTest {
    
    @Autowired
    private PersonDAO personDAO;
    
    /**
     * Test of loadById method, of class PersonDAOJdbcImpl.
     */
    @Test
    public void testLoadById() {
        System.out.println("loadById");
        
        Person person = personDAO.loadById(1);
        
        System.out.println(person);
        
//        assertEquals("niepoprawne imię", "Adam", p.getName());
//        assertEquals("niepoprawne id", 1L, (long)p.getId());
        
        assertThat(person.getName(), equalToIgnoringCase("adam"));
        
    }

    /**
     * Test of loadAll method, of class PersonDAOJdbcImpl.
     */
    @Test
    public void testLoadAll() {
        
        System.out.println("loadAll");
        
        List<Person> res = personDAO.loadAll();
        
        System.out.println(res);
        
        assertThat(res.size(), is(equalTo(2)));
        
    }

    /**
     * Test of save method, of class PersonDAOJdbcImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Person person = new Person();
        
        person.setLastName("Nowakowski");
        person.setName("Janusz");
        
        long id = personDAO.save(person);
        
        System.out.println("id = " + id);
        
        assert id == 3;
        
    }

    /**
     * Test of update method, of class PersonDAOJdbcImpl.
     */
    @Test
    public void testUpdate() {
        
        System.out.println("update");
        
        Person person = personDAO.loadById(1L);
        person.setName("Karol");
        
        personDAO.update(person);
        
        Person newPerson = personDAO.loadById(1L);
        
        assertThat(newPerson.getName(), is(equalTo("Karol")));
        
    }

    

    

    
    
    
    
}
