package pl.com.softproject.spring.ws.ws;
/**
 * Copyright 2015-06-19 the original author or authors.
 */

import javax.jws.WebService;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@WebService(endpointInterface = "pl.com.softproject.spring.ws.ws.HelloService")
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHallo(String name) {
        return "hello " + name;
    }
}
