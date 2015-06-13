/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        
        ModelAndView model = new ModelAndView("edit_user");
        model.addObject("user", new User());
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user) {
        
        System.out.println(user);
        
        userDAO.save(user);
        
        return "redirect:add";
    }
    
    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ModelAndView display1(@PathVariable(value = "login") String login) {
        
        User user = userDAO.findOne(login);
        
        System.out.println(user);
        
        ModelAndView model = new ModelAndView("edit_user");
        model.addObject("user", new User());
        
        return model;
        
    }
    
    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ModelAndView display(@RequestParam(value = "login", required = true) String login) {
        
        User user = userDAO.findOne(login);
        
        System.out.println(user);
        
        ModelAndView model = new ModelAndView("edit_user");
        model.addObject("user", new User());
        
        return model;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("users", userDAO.findAll());
        
        return "user-list";
        
    }
    
    
}
