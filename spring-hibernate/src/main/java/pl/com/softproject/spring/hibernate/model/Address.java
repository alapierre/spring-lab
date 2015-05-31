/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@Entity
public class Address extends BaseEntity {
    
    private String citi;
    private String street;
    private String postCode;

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false)
    private Person person;
    
    public Address() {
    }

    public Address(String citi, String street, String postCode) {
        this.citi = citi;
        this.street = street;
        this.postCode = postCode;
    }

    public Address(Long id) {
        super(id);
    }

    public String getCiti() {
        return citi;
    }

    public void setCiti(String citi) {
        this.citi = citi;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
