/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.SaleStatus;
import com.thunv.repository.SaleStatusRepository;
import java.util.List;
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
public class SaleStatusRepositoryImpl implements SaleStatusRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<SaleStatus> getListSaleStatus() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("From SaleStatus");
        return query.getResultList();
    }
    
}
