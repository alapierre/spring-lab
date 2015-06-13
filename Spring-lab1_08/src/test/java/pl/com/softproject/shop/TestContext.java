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
import pl.com.softproject.spring.lab1_08.dao.*;
import pl.com.softproject.spring.lab1_08.model.*;

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
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ProductDAO productDAO;

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
    public void testCategoryFindByParentId() {

        Category c = new Category();
        c.setName("Rowery");
        System.out.println("id = " + c.getId());
        categoryDAO.save(c);
        System.out.println("id = " + c.getId());
        Long parentId = c.getId();

        Category cc1 = new Category();
        cc1.setName("Rowery górskie");
        cc1.setParent(c);
        categoryDAO.save(cc1);

        Category cc2 = new Category();
        cc2.setName("Rowery szosowe");
        cc2.setParent(c);
        categoryDAO.save(cc2);

        List<Category> categories = categoryDAO.findByParentId(parentId);
        System.out.println(categories);
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

        Order o = new Order();
        Client c = new Client();
        c.setName("mariusz");

        o.setClient(c);

        Product p = new Product();
        p.setName("Rower Górski");

        //Order o = orderDAO.findAll().next();
        //Product o = productDAO.findAll().next();

        OrderItem i = new OrderItem();

        i.setProduct(p);
        i.setPrice(new BigDecimal(12.99));
        i.setQuantity(1);

        o.addItem(i);

        productDAO.save(p);

        clientDAO.save(c);

        orderDAO.save(o);
        orderItemDAO.save(i);

        System.out.println(orderItemDAO.findAll());
        System.out.println(orderDAO.findAll());
    }
}
