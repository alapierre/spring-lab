/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.jdbc.dao;

import java.util.List;
import pl.com.softproject.spring.jdbc.model.Person;

/**
 *
 * @author CSI
 */
public interface PersonDAO {

    Person loadById(long id);

    List<Person> loadAll();
    
}
