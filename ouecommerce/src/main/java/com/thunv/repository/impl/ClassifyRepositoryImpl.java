/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Classify;
import com.thunv.repository.ClassifyRepository;
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
public class ClassifyRepositoryImpl implements ClassifyRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Classify> getListClassifyByPostID(int postID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Classify> criteriaQuery = criteriaBuilder.createQuery(Classify.class);
        Root root = criteriaQuery.from(Classify.class);
        criteriaQuery.select(root);
        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("postID"), postID));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
