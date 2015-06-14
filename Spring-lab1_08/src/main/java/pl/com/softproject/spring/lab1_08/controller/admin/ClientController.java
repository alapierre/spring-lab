/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller.admin;

import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.spring.lab1_08.dao.AddressDAO;
import pl.com.softproject.spring.lab1_08.dao.ClientDAO;
import pl.com.softproject.spring.lab1_08.model.Address;
import pl.com.softproject.spring.lab1_08.model.Client;
import pl.com.softproject.spring.lab1_08.model.CustommerDto;

/**
 *
 * @author S108_11
 */
@Controller
@RequestMapping("/admin/client")
public class ClientController {
    
    @Autowired
    private ClientDAO clientDAO;
    
    @Autowired
    private AddressDAO addressDAO;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        
        ModelAndView model = new ModelAndView("edit_client");
        model.addObject("client", new CustommerDto());
        
        return model;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "id") Long id) {
        
        Client editClient = clientDAO.findOne(id);
        
        Set<Address> ad =  editClient.getAddresses();
        
        Address editAddress = addressDAO.findOne(ad.iterator().next().getId().toString());
        
        CustommerDto cd = new CustommerDto();
        cd.setName(editClient.getName());
        cd.setLastName(editClient.getLastName());
        cd.setStreet(editAddress.getStreet());
        cd.setCity(editAddress.getCity());
        cd.setPostCode(editAddress.getPostCode());
        
        ModelAndView model = new ModelAndView("edit_client");
        model.addObject("client", cd);
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid CustommerDto client, BindingResult br) {
        
        System.out.println(client);
        
        if(br.hasErrors()) {
            
            System.out.println(br.getAllErrors());
            
            ModelAndView m = new ModelAndView("edit_client");
            m.addObject("client", client);
            return m;
        }
        
        Client c = new Client();
        
        Address address = new Address();
        address.setCity(client.getCity());
        address.setPostCode(client.getPostCode());
        address.setStreet(client.getStreet());
        address.setType(Address.AddressType.HOME);
        
        c.getAddresses().add(address);
        c.setName(client.getName());
        c.setLastName(client.getLastName());
        
        address.setClient(c);
        
        clientDAO.save(c);
        
        return new ModelAndView("redirect:list");
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("clients", clientDAO.findAll());
        
        return "client-list";
        
    }
}
