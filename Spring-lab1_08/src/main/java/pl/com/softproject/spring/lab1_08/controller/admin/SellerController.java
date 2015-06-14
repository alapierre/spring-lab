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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        
        ModelAndView model = new ModelAndView("edit_seller");
        model.addObject("sellerDto", new SellerDto());
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid SellerDto sellerDto, BindingResult br) {
        
        System.out.println(sellerDto);
        
        if(br.hasErrors()) {
            System.out.println(br.getAllErrors());
            ModelAndView m = new ModelAndView("edit_seller");
            m.addObject("sellerDto", sellerDto);
            m.addObject("errors", br.getAllErrors());
            //m.addObject("categories", categoryDAO.findAll());
            return m;
        }
        
        User u = new User();
        Seller s = new Seller();
        
        u.setLogin(sellerDto.getLogin());
        u.setPassword(sellerDto.getPassword());
        u.setActive(true);
        s.setId(sellerDto.getId());
        s.setUser(u);
        s.setEmail(sellerDto.getEmail());
        s.setNumberPhone(sellerDto.getNumberPhone());

        userDAO.save(u);
        sellerDAO.save(s);

        return new ModelAndView("redirect:list");
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("sellers", sellerDAO.findAll());
        
        return "seller-list"; 
    }
    
    @RequestMapping(value = "/edit/{login}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("login") String login) {
        
        
        ModelAndView model = new ModelAndView("edit_seller");
        
        User u = userDAO.findOne(login);
        Seller s = sellerDAO.findByUserLoginIgnoreCaseLike(login);
        
        SellerDto sd = new SellerDto();
        sd.setId(s.getId());
        sd.setLogin(u.getLogin());
        sd.setPassword(u.getPassword());
        sd.setEmail(s.getEmail());
        sd.setNumberPhone(s.getNumberPhone());
        
        model.addObject("sellerDto", sd);
        
        return model;
    }
    
}
