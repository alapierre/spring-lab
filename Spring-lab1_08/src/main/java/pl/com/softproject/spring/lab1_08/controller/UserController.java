/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.com.softproject.spring.lab1_08.dao.UserDAO;
import pl.com.softproject.spring.lab1_08.model.User;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserDAO userDAO;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User display(String login) {
        
        return userDAO.findOne(login);
    }
    
    
}
