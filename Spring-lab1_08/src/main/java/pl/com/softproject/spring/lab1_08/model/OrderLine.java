/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import com.sun.security.ntlm.Client;
import java.math.BigDecimal;

/**
 *
 * @author S108_13
 */
public class OrderLine {
    
    //@ManyToOne
    //@JoinColumn(name="order_id")
    private Order order;
    //@ManyToOne
    //@JoinColumn(name="client_id")
    private Client client;
    //@ManyToOne
    //@JoinColumn(name="product_id")
    //private Product product;
    private Integer quantity;
    private BigDecimal price;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /*public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }*/

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
