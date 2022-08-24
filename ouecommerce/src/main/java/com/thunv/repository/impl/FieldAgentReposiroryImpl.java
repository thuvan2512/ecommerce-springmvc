/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.AgentField;
import com.thunv.repository.FieldAgentRepository;
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
public class FieldAgentReposiroryImpl implements FieldAgentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<AgentField> getListAgentFields() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("From AgentField");
        return query.getResultList();
    }
    
}
