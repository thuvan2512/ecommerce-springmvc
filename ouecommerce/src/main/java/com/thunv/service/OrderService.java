/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.Orders;
import com.thunv.pojo.User;
import com.thunv.subentity.Cart;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu.nv2512
 */
public interface OrderService {
    boolean addOrder(Map<Integer, Cart> cart,User user,int paymentType);
    boolean updateOrder(Orders order);
    boolean deleteOrder(Orders order);
    List<Orders> getListOrderByUserID(int userID);
    List<Orders> getOrderByID(int orderID);
    int countOrder();
    List<Orders> getListOrder();
}
