/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.shop;

import java.math.BigDecimal;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.spring.lab1_08.dao.AddressDAO;
import pl.com.softproject.spring.lab1_08.dao.CategoryDAO;
import pl.com.softproject.spring.lab1_08.dao.OrderItemDAO;
import pl.com.softproject.spring.lab1_08.model.Category;
import pl.com.softproject.spring.lab1_08.model.OrderItem;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Spring-lab1_08-test.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestContext {
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Autowired
    private AddressDAO addressDAO;
    
    @Autowired
    private OrderItemDAO orderItemDAO;
    
    @Test
    public void test() {
        
    }
    
    @Test
    public void testCategory() {

        Category c = new Category();

        c.setName("Rowery górskie");

        System.out.println("id = " + c.getId());
        
        categoryDAO.save(c);
        
        System.out.println("id = " + c.getId());
    }
    
    @Test
    public void testCategoryFind() {

        Category c = new Category();

        c.setName("Rowery górskie");

        System.out.println("id = " + c.getId());
        
        categoryDAO.save(c);
        
        System.out.println("id = " + c.getId());
        
        List<Category> categories = categoryDAO.findByNameIgnoreCaseLike("%rowery%");
        
        System.out.println(categories.get(0).getName());
    }
    
    @Test
    public void testOrderItem() {

        OrderItem i = new OrderItem();

        i.setPrice(new BigDecimal(12.99));
        i.setQuantity(1);

        System.out.println(i);
        
        orderItemDAO.save(i);
        
        System.out.println(i);
    }
    
}
