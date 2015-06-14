/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.spring.lab1_08.dao.CategoryDAO;
import pl.com.softproject.spring.lab1_08.model.Category;

/**
 *
 * @author Agata Kolodynska <agata.kolodynska@gmail.com>
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        
        ModelAndView model = new ModelAndView("category_edit");
        model.addObject("category", new Category());	
        model.addObject("categories", categoryDAO.findAll());
        
        return model;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id) {
        
        ModelAndView model = new ModelAndView("category_edit");
        model.addObject("category", categoryDAO.findOne(id));
        model.addObject("categories", categoryDAO.findAll());
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid Category category, BindingResult br) {
        
        System.out.println(category);
        
        if(br.hasErrors()) {
            System.out.println(br.getAllErrors());
            ModelAndView m = new ModelAndView("category_edit");
            m.addObject("category", category);
            m.addObject("categories", categoryDAO.findAll());
            return m;
        }
        
        categoryDAO.save(category);
        
        return new ModelAndView("redirect:list");
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("categories", categoryDAO.findAll());
        
        return "category_list";
        
    }
    
}
