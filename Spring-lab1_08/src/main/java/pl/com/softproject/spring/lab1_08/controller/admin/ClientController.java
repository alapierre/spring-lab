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
        model.addObject("custommerDto", new CustommerDto());

        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "id") Long id) {

        Client editClient = clientDAO.findOne(id);

        Set<Address> ad = editClient.getAddresses();

        ModelAndView model = new ModelAndView("edit_client");

        CustommerDto cd = new CustommerDto();
        cd.setId(editClient.getId());
        cd.setName(editClient.getName());
        cd.setLastName(editClient.getLastName());
        
        if (!ad.isEmpty()) {
            cd.setStreet(ad.iterator().next().getStreet());
            cd.setCity(ad.iterator().next().getCity());
            cd.setPostCode(ad.iterator().next().getPostCode());
            
        } else {
            cd.setStreet("");
            cd.setCity("");
            cd.setPostCode("");
        
        }

        model.addObject("custommerDto", cd);
        
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid CustommerDto custommer, BindingResult br) {

        System.out.println(custommer);

        if (br.hasErrors()) {

            return "edit_client";
        }

        Client c = new Client();

        Address address = new Address();
        address.setCity(custommer.getCity());
        address.setPostCode(custommer.getPostCode());
        address.setStreet(custommer.getStreet());
        address.setType(Address.AddressType.HOME);

        c.setId(custommer.getId());
        c.getAddresses().add(address);
        c.setName(custommer.getName());
        c.setLastName(custommer.getLastName());

        address.setClient(c);

        clientDAO.save(c);

        addressDAO.save(address);

        return "redirect:list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("clients", clientDAO.findAll());

        return "client-list";

    }
}
