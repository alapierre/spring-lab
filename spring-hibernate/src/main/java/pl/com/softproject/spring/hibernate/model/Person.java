package pl.com.softproject.spring.hibernate.model;
/**
 * Copyright 2015-05-26 the original author or authors.
 */

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
public class Person extends BaseEntity {

    private String name;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Set<Address> addresses = new LinkedHashSet<>();
    
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    
    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }
}
