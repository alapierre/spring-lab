/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.Order;
import pl.com.softproject.spring.lab1_08.model.Shipment;

/**
 *
 * @author S108_11
 */
public interface ShipmentDAO extends CrudRepository<Shipment, Long>{
    public List<Order> findByOrderId(Long id);
}
