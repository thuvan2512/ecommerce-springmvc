/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.AuthProvider;
import com.thunv.pojo.Role;
import com.thunv.repository.AuthProviderRepository;
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
public class AuthProviderRepositoryImpl implements AuthProviderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public AuthProvider getAuthProviderByID(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createNamedQuery("AuthProvider.findByAuthID");
        query.setParameter("authID", id);
        return (AuthProvider) query.getSingleResult();
    }

}
