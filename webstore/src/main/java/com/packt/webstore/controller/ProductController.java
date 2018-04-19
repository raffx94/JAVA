/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.packt.webstore.domain.Repository.RepositoryProduct;

/**
 *
 * @author Rafał
 */
@Controller
public class ProductController {

    @Autowired
    private RepositoryProduct productrepository;

    @RequestMapping("/products")
    public String list(Model model) {

        model.addAttribute("products", productrepository.getAllProducts());

        return "products";

    }

}
