/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.spring.lab1_08.model.Address;
import pl.com.softproject.spring.lab1_08.model.Client;
import pl.com.softproject.spring.lab1_08.model.Order;
import pl.com.softproject.spring.lab1_08.model.OrderItem;
import pl.com.softproject.spring.lab1_08.model.Product;
import pl.com.softproject.spring.lab1_08.model.User;

/**
 *
 * @author S108_11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Spring-lab1_08-test.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class OrderDAOTest {
    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private ClientDAO clientDAO;
    
    @Autowired
    private AddressDAO addressDAO;
    
    @Autowired
    private ProductDAO productDAO;

    @Test
    public void testSomeMethod() throws ParseException {
        
        
        User user = userDAO.findOne("user");
        
        System.out.println("User: " + user);
        
        Client client = new Client();
        client.setName("Jan");
        client.setLastName("Kowalski");
        
        client.setUser(user);
        
        clientDAO.save(client);
        
        
        Set<Address> a = new LinkedHashSet<>();
        
        Address address = new Address();
        address.setCity("Lublin");
        address.setPostCode("20-542");
        address.setType(Address.AddressType.HOME);
        address.setStreet("Blotna");
        address.setClient(client);
        
        addressDAO.save(address);
        
        a.add(address);
        
        
        
        Product product = new Product();
        product.setCategory(null);
        
        
        productDAO.save(product);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2013-10-10 10:49:29.10000";
        Date newDate = format.parse(date);
        
        Order order = new Order();
        
        OrderItem items = new OrderItem();
        items.setOrder(order);
        items.setPrice(new BigDecimal(0.35));
        items.setProduct(product);
        
        order.setClient(client);
        order.setOrderDate(newDate);
        
        
        orderDAO.save(order);
        
        System.out.println(orderDAO.findAll());
    }
}
