/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.OrderState;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface OrderStateService {
     List<OrderState> getOrderStateByID(int id);
     List<OrderState> getListOrderState();
}
