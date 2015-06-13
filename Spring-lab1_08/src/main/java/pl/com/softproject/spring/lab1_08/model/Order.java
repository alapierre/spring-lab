/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author S108_11
 */

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date orderDate;
    
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
    
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    public Order addItem(OrderItem item) {
        
        item.setOrder(this);
        orderItems.add(item);
        
        return this;
        
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" + "orderDate=" + orderDate + ", client=" + client + ", orderItems=" + orderItems + '}';
    }

    
    
}
