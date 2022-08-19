/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Item;
import com.thunv.subentity.Cart;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.Orders;
import com.thunv.pojo.User;
import com.thunv.repository.OrderRepository;
import com.thunv.service.ItemService;
import com.thunv.service.OrderStateService;
import com.thunv.service.PaymentTypeService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu.nv2512
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private Utils utils;
    @Autowired
    private OrderStateService orderStateService;
    @Autowired
    private PaymentTypeService paymentTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(Map<Integer, Cart> cart, User user,int paymentType) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            Orders order = new Orders();
            System.err.println("KKKK");
            order.setPaymentState(0);
            order.setTotalPrice(this.utils.getTotalPriceCart(cart));
            order.setCreatedDate(new Date());
            order.setUserID(user);
            order.setOrderState(this.orderStateService.getOrderStateByID(1).get(0));
            order.setPaymentType(this.paymentTypeService.getPaymentStateByID(paymentType).get(0));
            session.save(order);
            for (Cart c: cart.values()) {
                OrderDetails od = new OrderDetails();
                od.setQuantity(c.getQuantity());
                od.setItemID(this.itemService.getItemByID(c.getItemID()).get(0));
                od.setOrderID(order);
                Item item = this.itemService.getItemByID(c.getItemID()).get(0);
                int qty = item.getInventory();
                item.setInventory(qty - c.getQuantity());
                session.update(item);
                session.save(od);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
