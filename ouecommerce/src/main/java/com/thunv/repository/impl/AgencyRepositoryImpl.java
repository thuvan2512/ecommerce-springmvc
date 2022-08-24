/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import com.thunv.repository.AgencyRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class AgencyRepositoryImpl implements AgencyRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public boolean registerAgency(Agency agency) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(agency);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkUserManager(User user) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Agency> criteriaQuery = criteriaBuilder.createQuery(Agency.class);
        Root root = criteriaQuery.from(Agency.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("manager"), user));
        Query query = session.createQuery(criteriaQuery);
        if (query.getResultList().size() != 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<Agency> getAgencyByUserID(int i) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Agency> criteriaQuery = criteriaBuilder.createQuery(Agency.class);
        Root root = criteriaQuery.from(Agency.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("manager"), i));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
