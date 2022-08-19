/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.OrderState;
import com.thunv.repository.OrderStateRepository;
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
public class OrderStateRepositoryImpl implements OrderStateRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<OrderState> getOrderStateByID(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<OrderState> criteriaQuery = criteriaBuilder.createQuery(OrderState.class);
        Root root = criteriaQuery.from(OrderState.class);
        criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.equal(root.get("osID").as(Integer.class), id);
        criteriaQuery = criteriaQuery.where(predicate);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
