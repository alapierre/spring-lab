/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.User;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public interface UserDAO extends CrudRepository<User, String>{
    
}
