/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.Service;

/**
 *
 * @author Rafał
 */
public interface OrderService {
    void processOrder(String productId, int count);
}
