/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

/**
 *
 * @author S108_8
 */
public class Stock extends BaseEntity{
    
//    private Product id_product;
    private Long volume;

//    public Product getId_product() {
//        return id_product;
//    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

}
