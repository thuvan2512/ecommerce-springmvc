/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Agency;
import com.thunv.pojo.CensorshipAgent;
import com.thunv.pojo.Item;
import com.thunv.pojo.LikePost;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.Orders;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.repository.AgencyRepository;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu.nv2512
 */
@Repository
public class AgencyRepositoryImpl implements AgencyRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean registerAgency(Agency agency) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            CensorshipAgent censorship = new CensorshipAgent();
            agency.setIsActive(0);
            session.save(agency);
            censorship.setAgencyID(agency);
            censorship.setUserID(agency.getManager());
            censorship.setCreatedDate(new Date());
            session.save(censorship);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    @Transactional
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
    @Transactional
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

    @Override
    @Transactional
    public boolean updateAgency(Agency agency) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.update(agency);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    @Transactional
    public List<Agency> getListAgencyNeedCensorship() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Agency> criteriaQuery = criteriaBuilder.createQuery(Agency.class);
        Root root = criteriaQuery.from(Agency.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("isCensored").as(Integer.class), 0));
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("createdDate")));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Agency> getAgencyByID(int agencyID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Agency.findByAgencyID");
        query.setParameter("agencyID", agencyID);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean deleteAgency(Agency agency) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.delete(agency);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    @Transactional
    public List<Agency> getListAgencyByActive(int active) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Agency> criteriaQuery = criteriaBuilder.createQuery(Agency.class);
        Root root = criteriaQuery.from(Agency.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("isCensored").as(Integer.class), 1),
                criteriaBuilder.equal(root.get("isActive").as(Integer.class), active));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdDate")));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int countAgency() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM Agency a WHERE a.isCensored = 1");
        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    @Transactional
    public List<Object[]> getTopAgency(int top) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root root = criteriaQuery.from(Agency.class);
        Root rootPost = criteriaQuery.from(SalePost.class);
        Root rootLike = criteriaQuery.from(LikePost.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("isCensored").as(Integer.class), 1),
                criteriaBuilder.equal(root.get("isActive").as(Integer.class), 1),
                criteriaBuilder.equal(rootPost.get("agencyID"), root.get("agencyID")),
                criteriaBuilder.equal(rootPost.get("postID"), rootLike.get("postID")));
        criteriaQuery.multiselect(root, criteriaBuilder.count(rootLike.get("likeID")).as(Integer.class));
        criteriaQuery.groupBy(root.get("agencyID"));
        Query query = session.createQuery(criteriaQuery);
        query.setMaxResults(top);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Object[]> getStatsSaleFrequency(int top,int year, int quarter) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootItem = query.from(Item.class);
        Root rootOrderDetail = query.from(OrderDetails.class);
        Root rootPost = query.from(SalePost.class);
        Root rootOrder = query.from(Orders.class);
        Root rootAgency = query.from(Agency.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = builder.equal(rootAgency.get("agencyID"), rootPost.get("agencyID"));
        predicates.add(p1);
        Predicate p2 = builder.equal(rootItem.get("itemID"), rootOrderDetail.get("itemID"));
        predicates.add(p2);
        Predicate p3 = builder.equal(rootItem.get("postID"), rootPost.get("postID"));
        predicates.add(p3);
        Predicate p4 = builder.equal(rootOrderDetail.get("orderID"), rootOrder.get("orderID"));
        predicates.add(p4);
        Predicate p5 = builder.equal(builder.function("YEAR", Integer.class, rootOrder.get("createdDate")), year);
        predicates.add(p5);
        Predicate p6 = builder.equal(builder.function("QUARTER", Integer.class, rootOrder.get("createdDate")), quarter);
        predicates.add(p6);
        query.where(predicates.toArray(new Predicate[]{}));
        query.multiselect(rootAgency.get("name"), builder.sum(rootOrderDetail.get("quantity")).as(Integer.class));
        query.groupBy(rootAgency.get("name"));
        Query q = session.createQuery(query);
        q.setMaxResults(top);
        return q.getResultList();
    }
}
