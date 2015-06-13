/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.Address;
import pl.com.softproject.spring.lab1_08.model.OrderItem;

/**
 *
 * @author S108_13
 */
public interface OrderItemDAO extends CrudRepository<OrderItem, String> {

    public List<OrderItem> findByOrderId(Long id);

    public List<OrderItem> findByProductId(Long id);

    public OrderItem findById(Long id);
}
