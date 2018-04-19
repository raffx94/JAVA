/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.controller;

import com.packt.webstore.domain.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rafał
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @RequestMapping("/order/p12")
    public String process() {
        orderservice.processOrder("p12", 100);
        return "redirect:/products";
    }

}
