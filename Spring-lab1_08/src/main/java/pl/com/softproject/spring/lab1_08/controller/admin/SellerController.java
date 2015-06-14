/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller.admin;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.spring.lab1_08.dao.SellerDAO;
import pl.com.softproject.spring.lab1_08.dao.UserDAO;
import pl.com.softproject.spring.lab1_08.model.Seller;
import pl.com.softproject.spring.lab1_08.model.SellerDto;
import pl.com.softproject.spring.lab1_08.model.User;

/**
 *
 * @author S108_8
 */

@Controller
@RequestMapping("/admin/seller")
public class SellerController {

    @Autowired
    private SellerDAO sellerDAO;
    
    @Autowired
    private UserDAO userDAO;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        
        ModelAndView model = new ModelAndView("add_seller");
        model.addObject("seller", new SellerDto());
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid SellerDto seller, BindingResult br) {
        
        System.out.println(seller);
        
        if(br.hasErrors()) {
            return "add_seller";
        }
        
        User u = new User();
        Seller s = new Seller();
        
        u.setLogin(seller.getLogin());
        u.setPassword(seller.getPassword());
        u.setActive(true);
        s.setUser(u);
        s.setEmail(seller.getEmail());
        s.setNumberPhone(seller.getNumberPhone());

        userDAO.save(u);
        sellerDAO.save(s);

        return "redirect:list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("sellers", sellerDAO.findAll());
        
        return "seller-list"; 
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView display(@RequestParam(value = "login", required = true) String login) {
        
        User u = userDAO.findOne(login);
        
        System.out.println(u);

        ModelAndView model = new ModelAndView("add_seller");
        model.addObject("seller", new Seller());
        
        return model;
    }
    
}
