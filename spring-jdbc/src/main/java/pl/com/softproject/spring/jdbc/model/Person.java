package pl.com.softproject.spring.jdbc.model;
/**
 * Copyright 2015-05-27 the original author or authors.
 */

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Person {


    private Long id;
    private String name;
    private String lastName;

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
}
