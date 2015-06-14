/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import javax.validation.constraints.Size;

/**
 *
 * @author S108_11
 */
public class CustommerDto {

    private Long id;
    
    @Size(min = 2, max = 64)
    private String name;

    @Size(min = 2, max = 128)
    private String lastName;

    @Size(max = 128)
    private String street;
    @Size(max = 128)
    private String city;
    @Size(max = 6)
    private String postCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "CustommerDto{" + "name=" + name + ", lastName=" + lastName + ", street=" + street + ", city=" + city + ", postCode=" + postCode + '}';
    }
    
}
