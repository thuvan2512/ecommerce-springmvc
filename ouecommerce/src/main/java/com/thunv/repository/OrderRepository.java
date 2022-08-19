/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.User;
import com.thunv.subentity.Cart;
import java.util.Map;

/**
 *
 * @author thu.nv2512
 */
public interface OrderRepository {
    boolean addOrder(Map<Integer, Cart> cart,User user,int paymentType);
}
