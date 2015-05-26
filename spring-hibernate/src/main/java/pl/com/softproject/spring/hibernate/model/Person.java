package pl.com.softproject.spring.hibernate.model;
/**
 * Copyright 2015-05-26 the original author or authors.
 */

import javax.persistence.Entity;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
public class Person extends BaseEntity {

    private String name;
    private String lastName;

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

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }
}
