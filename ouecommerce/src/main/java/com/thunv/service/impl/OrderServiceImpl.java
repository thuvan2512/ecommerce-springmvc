/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.User;
import com.thunv.subentity.Cart;
import com.thunv.repository.OrderRepository;
import com.thunv.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addOrder(Map<Integer, Cart> cart, User user, int paymentType) {
        if (cart != null && user != null) {
            return this.orderRepository.addOrder(cart, user, paymentType);
        }
        return false;
    }

}
