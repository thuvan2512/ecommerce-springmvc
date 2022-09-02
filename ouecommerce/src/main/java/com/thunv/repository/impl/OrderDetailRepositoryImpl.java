/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Item;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.SalePost;
import com.thunv.repository.OrderDetailsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu.nv2512
 */
@Repository
@Transactional
public class OrderDetailRepositoryImpl implements OrderDetailsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<OrderDetails> getListOrderDetailByOrderID(int orderID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderDetails> query = builder.createQuery(OrderDetails.class);
        Root root = query.from(OrderDetails.class);
        query.select(root);
        query.where(builder.equal(root.get("orderID"), orderID));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<OrderDetails> getListOrderDetailByAgentID(int agentID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootItem = query.from(Item.class);
        Root rootOrder = query.from(OrderDetails.class);
        Root rootPost = query.from(SalePost.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = builder.equal(rootPost.get("agencyID"), agentID);
        predicates.add(p1);
        Predicate p2 = builder.equal(rootItem.get("itemID"), rootOrder.get("itemID"));
        predicates.add(p2);
        Predicate p3 = builder.equal(rootItem.get("postID"), rootPost.get("postID"));
        predicates.add(p3);
        query.where(predicates.toArray(new Predicate[]{}));
        query.select(rootOrder);
        query.distinct(true);
        query.orderBy(builder.desc(rootOrder.get("orderID")));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

}
