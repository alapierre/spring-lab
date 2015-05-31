/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.com.softproject.spring.model.Person;

/**
 *
 * @author CSI
 */
public class PersonConverter implements Converter<String, Person> {

    @Override
    public Person convert(String s) {
        Person p = new Person();

        String[] res = s.split(";");

        p.setId(Long.parseLong(res[0]));
        p.setName(res[1]);
        p.setSurname(res[2]);

        return p;
    }

}
