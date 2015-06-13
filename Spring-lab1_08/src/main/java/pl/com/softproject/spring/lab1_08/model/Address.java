/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author S108_5
 */
@Entity
public class Address extends BaseEntity {

    public static enum AddressType {

        CORRESPONDENCE, HOME
    };

    @Size(max = 128)
    private String street;
    @Size(max = 128)
    private String city;
    @Size(max = 6)
    private String postCode;
    private AddressType type;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", postCode=" + postCode + ", type=" + type  + "id=" + getId() + ", client=" + client +  '}';
    }

    
    
}
