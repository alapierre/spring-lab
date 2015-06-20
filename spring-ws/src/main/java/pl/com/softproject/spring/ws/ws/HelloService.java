package pl.com.softproject.spring.ws.ws;

import javax.jws.WebService;

/**
 * Copyright 2015-06-19 the original author or authors.
 */
@WebService
public interface HelloService {

    String sayHallo(String name);

}
