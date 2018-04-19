/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.Service;

import com.packt.webstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.Repository.RepositoryProduct;

/**
 *
 * @author Rafał
 */
@Service
public class OrderServiceImpl implements OrderService {

    
    @Autowired
    private RepositoryProduct productrepository;
    
    @Override
    public void processOrder(String productId, int count) {
       Product productById=productrepository.getProductById(productId);
       
       
           productById.setUnitsInStock(productById.getUnitsInStock() - count);
       
    }
    
}
