/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.com.softproject.spring.lab1_08.model.Product;

/**
 *
 * @author S108_1
 */
public interface ProductDAO extends CrudRepository<Product, String>{
    public List<Product> findByNameIgnoreCase(String name);
    
}
