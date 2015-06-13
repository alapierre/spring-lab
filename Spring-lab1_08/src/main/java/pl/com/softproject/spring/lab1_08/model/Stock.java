/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author S108_8
 */

@Entity
public class Stock extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private Product product;
    private Long volume;

    public Product getProduct() {
        return product;
    }

    public Long getVolume() {
        return volume;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

}
