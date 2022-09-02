/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.OrderDetails;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface OrderDetailService {
    List<OrderDetails> getListOrderDetailByOrderID(int orderID);
    List<OrderDetails> getListOrderDetailByAgentID(int agentID);
}
