/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.Stock;

/**
 *
 * @author S108_8
 */
public interface StockDAO extends CrudRepository<Stock, String>{
    
    public List<Stock> findByProductId(Long id);
    public List<Stock> findByProductName(String name);
}