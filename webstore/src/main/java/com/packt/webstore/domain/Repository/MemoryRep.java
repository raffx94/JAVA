/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.Repository;

import com.packt.webstore.domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafał
 */
@Repository
public class MemoryRep implements RepositoryProduct {

    private List<Product> listOfProduct = new ArrayList<Product>();

    public MemoryRep() {

        Product ip = new Product("p12", "ip2", new BigDecimal(500));
        ip.setCategory("aaa");
        ip.setDescription("sdsdsd");

        ip.setUnitsInStock(333);

        Product laptop = new Product("p12", "ip2", new BigDecimal(500));
        ip.setCategory("aaa");
        ip.setDescription("sdsdsd");

        ip.setUnitsInStock(347);

        Product laptops = new Product("p123", "ip2", new BigDecimal(500));
        ip.setCategory("aaa");
        ip.setDescription("sdsdsddadjnadkjnaksndkjasnkdaskdnksjadn");

        ip.setUnitsInStock(342227);

        listOfProduct.add(ip);
        listOfProduct.add(laptops);
        listOfProduct.add(laptop);

    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProduct) {
            if (product != null && product.getProdID() != null && product.getProdID().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new IllegalArgumentException("brak produktu");
        }
        return productById;
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProduct;
    }

}
