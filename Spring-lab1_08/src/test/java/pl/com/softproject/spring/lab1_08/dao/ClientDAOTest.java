/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.spring.lab1_08.model.Address;
import pl.com.softproject.spring.lab1_08.model.Client;
import pl.com.softproject.spring.lab1_08.model.User;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Spring-lab1_08-test.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class ClientDAOTest {
    
    @Autowired
    private ClientDAO clientDAO;
    
    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private UserDAO userDAO;
    
    @Test
    public void testSomeMethod() {
        
        User user = userDAO.findOne("user");
        
        Client client = new Client();
        client.setName("Kamil");
        client.setLastName("Kunikowski");
        client.setUser(user);
        
        Address address = new Address();
        address.setCity("Lublin");
        address.setPostCode("11-111");
        address.setStreet("super ulica");
        address.setType(Address.AddressType.HOME);
        address.setClient(client);
        
        clientDAO.save(client);
        addressDAO.save(address);
        
        System.out.println(clientDAO.findByLastName("Kunikowski"));
        System.out.println(address.toString());
    }
    
}
