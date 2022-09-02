/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.OrderDetails;
import com.thunv.repository.OrderDetailsRepository;
import com.thunv.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getListOrderDetailByOrderID(int orderID) {
        return this.orderDetailsRepository.getListOrderDetailByOrderID(orderID);
    }

    @Override
    public List<OrderDetails> getListOrderDetailByAgentID(int agentID) {
        return this.orderDetailsRepository.getListOrderDetailByAgentID(agentID);
    }
    
}
