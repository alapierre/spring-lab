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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.com.softproject.spring.lab1_08.dao.OrderDAO;
import pl.com.softproject.spring.lab1_08.dao.OrderItemDAO;
import pl.com.softproject.spring.lab1_08.model.Order;
import pl.com.softproject.spring.lab1_08.model.OrderItem;

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

    @RequestMapping(value = "/item-edit/{item-id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "item-id") String itemId) {
        //Order order = orderDAO.findOne(new Long(orderId));
        OrderItem item = orderItemDAO.findById(new Long(itemId));

        //model.addAttribute("order", order);
        model.addAttribute("item", item);

        return "orders/item-edit";

    }

    @RequestMapping(value = "/item-save", method = RequestMethod.POST)
    public ModelAndView save(@Valid OrderItem item, BindingResult br) {

        System.out.println(item);

        if (br.hasErrors()) {
            ModelAndView model = new ModelAndView("orders/item-edit");
            model.addObject("item", item);
            return model;
        }

        orderItemDAO.save(item);

        return new ModelAndView("redirect:item-list/" + item.getOrder().getId());
    }
}
