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
import com.thunv.service.OrderDetailService;
import com.thunv.service.OrderStateService;
import com.thunv.service.PaymentTypeService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(Map<Integer, Cart> cart, User user, int paymentType) {
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
            for (Cart c : cart.values()) {
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

    @Override
    @Transactional
    public List<Orders> getListOrderByUserID(int userID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root root = query.from(Orders.class);
        query.select(root);
        query.where(builder.equal(root.get("userID"), userID));
        query.orderBy(builder.desc(root.get("createdDate")));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public int countOrder() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM Orders");
        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    @Transactional
    public List<Orders> getListOrder() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("From Orders o ORDER BY o.createdDate DESC");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Orders> getOrderByID(int orderID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> criteriaQuery = criteriaBuilder.createQuery(Orders.class);
        Root root = criteriaQuery.from(Orders.class);
        criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.equal(root.get("orderID").as(Integer.class), orderID);
        criteriaQuery = criteriaQuery.where(predicate);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean updateOrder(Orders order) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.update(order);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteOrder(Orders order) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.delete(order);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
