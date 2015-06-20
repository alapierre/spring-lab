/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.spring.lab.intro;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public class C {
    
    private Interface service;

    public C(Interface service) {
        this.service = service;
    }

    public C() {
    }
    
    public void doStuff() {
        service.sayHello();
    }

    public Interface getService() {
        return service;
    }

    public void setService(Interface service) {
        this.service = service;
    }
    
}
