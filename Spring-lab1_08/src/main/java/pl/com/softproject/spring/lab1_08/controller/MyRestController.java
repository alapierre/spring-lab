/*
 * Copyright 2015-05-26 the original author or authors.
 */
package pl.com.softproject.spring.lab1_08.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.softproject.spring.lab1_08.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {
    
    @RequestMapping(value = "/person", produces = "application/json;utf-8")
    public Person loadPerson() {
        
        Person p = new Person();
        p.setLastName("Kowalski");
        p.setName("Jan ąłńść");
        
        return p;
        
    }
    
}
