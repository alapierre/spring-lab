/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.controller.orders;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.spring.lab1_08.dao.ClientDAO;
import pl.com.softproject.spring.lab1_08.dao.OrderDAO;
import pl.com.softproject.spring.lab1_08.model.Client;
import pl.com.softproject.spring.lab1_08.model.Order;

/**
 *
 * @author S108_13
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ClientDAO clientDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        Iterable<Order> orders = orderDAO.findAll();

        model.addAttribute("orders", orders);

        return "orders/list";

    }

    @RequestMapping(value = "/edit/{order-id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "order-id") String orderId) {
        Order order = orderDAO.findOne(new Long(orderId));
        Iterable<Client> clients = clientDAO.findAll();

        model.addAttribute("clients", clients);
        model.addAttribute("order", order);

        return "orders/edit";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid Order order, BindingResult br) {

        System.out.println(order);

        if (br.hasErrors()) {
            ModelAndView model = new ModelAndView("orders/edit");
            model.addObject("order", order);
            return model;
        }

        orderDAO.save(order);

        return new ModelAndView("redirect:list");
    }
}
