/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.Repository;

import com.packt.webstore.domain.Product;
import java.util.List;

/**
 *
 * @author Rafał
 */
public interface RepositoryProduct {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    
}
