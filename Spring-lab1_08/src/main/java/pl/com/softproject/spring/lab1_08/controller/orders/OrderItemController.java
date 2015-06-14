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
import pl.com.softproject.spring.lab1_08.dao.OrderDAO;
import pl.com.softproject.spring.lab1_08.dao.OrderItemDAO;
import pl.com.softproject.spring.lab1_08.model.Order;
import pl.com.softproject.spring.lab1_08.model.OrderItem;
import pl.com.softproject.spring.lab1_08.model.User;

/**
 *
 * @author S108_13
 */
@Controller
@RequestMapping("/orders")
public class OrderItemController {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderItemDAO orderItemDAO;
    
    @RequestMapping(value = "/item-list/{order-id}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable(value = "order-id") String orderId) {
        Order order = orderDAO.findOne(new Long(orderId));
        //Set<OrderItem> items = order.getOrderItems();
        //Iterable<OrderItem> items = orderItemDAO.findByOrderId(new Long(orderId));
        Iterable<OrderItem> items = orderItemDAO.findAll();
        
        model.addAttribute("order", order);
        model.addAttribute("items", items);
        
        return "orders/item-list";
        
    }
    
    @RequestMapping(value = "/item-edit/{order-id}/{item-id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "order-id") String orderId, @PathVariable(value = "item-id") String itemId) {
        Order order = orderDAO.findOne(new Long(orderId));
        OrderItem item = orderItemDAO.findById(new Long(itemId));
        
        model.addAttribute("order", order);
        model.addAttribute("item", item);
        
        return "orders/item-edit";
        
    }
    
    @RequestMapping(value = "/item-save", method = RequestMethod.POST)
    public String save(@Valid OrderItem item, BindingResult br) {
        
        System.out.println(item);
        
        if(br.hasErrors()) {
            return "orders/item-edit";
        }
        
        orderItemDAO.save(item);
        
        return "redirect:orders/item-list";
    }
}