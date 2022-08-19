/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.OrderState;
import com.thunv.repository.OrderStateRepository;
import com.thunv.service.OrderService;
import com.thunv.service.OrderStateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class OrderStateServceImpl implements OrderStateService{
    @Autowired 
    private OrderStateRepository orderStateRepository;

    @Override
    public List<OrderState> getOrderStateByID(int id) {
        return this.orderStateRepository.getOrderStateByID(id);
    }
    
}
