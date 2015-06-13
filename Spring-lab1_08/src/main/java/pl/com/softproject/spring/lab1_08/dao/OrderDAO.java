/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.Client;
import pl.com.softproject.spring.lab1_08.model.Order;

/**
 *
 * @author S108_11
 */
public interface OrderDAO extends CrudRepository<Order, Long>{
    public List<Client> findByClientId(Long id);
    public List<Date> findByOrderDate(Date id);
}
