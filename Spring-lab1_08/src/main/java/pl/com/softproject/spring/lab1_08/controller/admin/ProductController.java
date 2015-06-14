/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.spring.lab1_08.dao.CategoryDAO;
import pl.com.softproject.spring.lab1_08.dao.ProductDAO;
import pl.com.softproject.spring.lab1_08.model.Category;
import pl.com.softproject.spring.lab1_08.model.Product;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@Controller
@RequestMapping("/admin/product")
public class ProductController {
    
    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {

        ModelAndView model = new ModelAndView("edit_product");
        model.addObject("product", new Product());
        model.addObject("categories", categoryDAO.findAll());
        
        return model;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id) {

        ModelAndView model = new ModelAndView("edit_product");
        model.addObject("product", productDAO.findOne(id));
        model.addObject("categories", categoryDAO.findAll());
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Product product, BindingResult br) {

        System.out.println(product);
        
        if(br.hasErrors()) {
            return "edit_product";
        }

        productDAO.save(product);
        
        return "redirect:list";
    }
    
    
    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ModelAndView display(@RequestParam(value = "name", required = true) String name) {
        
        //Product product = productDAO.findOneByName(name);
        
       //    System.out.println(product);
        
        ModelAndView model = new ModelAndView("edit_product");
        model.addObject("product", new Product());
        
        return model;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("products", productDAO.findAll());
        
        return "product_list";
        
    }
    
    
}
