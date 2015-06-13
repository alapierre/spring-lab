/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.shop;

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
import pl.com.softproject.spring.lab1_08.model.Address;
import pl.com.softproject.spring.lab1_08.model.Category;
import pl.com.softproject.spring.lab1_08.model.Client;

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
    
}
