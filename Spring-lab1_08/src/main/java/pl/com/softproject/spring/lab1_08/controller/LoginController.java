/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@Controller
public class LoginController {
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
}
