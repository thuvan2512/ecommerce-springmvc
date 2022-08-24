/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Item;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.SalePost;
import com.thunv.repository.ItemRepository;
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
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Item> getItemByID(int itemID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Item.findByItemID");
        query.setParameter("itemID", itemID);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getTopSeller(int top) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootItem = query.from(Item.class);
        Root rootOrder = query.from(OrderDetails.class);
        query.where(builder.equal(rootItem.get("itemID"), rootOrder.get("itemID")));
        query.multiselect(rootItem.get("itemID"), rootItem.get("postID").as(SalePost.class), rootItem.get("name"),
                rootItem.get("unitPrice"), builder.sum(rootOrder.get("quantity")), rootItem.get("description"));
        query.groupBy(rootItem.get("itemID"));
        query.orderBy(builder.desc(builder.sum(rootOrder.get("quantity"))));
        Query q = session.createQuery(query);
        q.setMaxResults(top);
        return q.getResultList();
    }

    @Override
    public List<Item> getItemByPostID(int postID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> query = builder.createQuery(Item.class);
        Root root = query.from(Item.class);
        query = query.where(builder.equal(root.get("postID"), postID));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public int countSoldByAgentID(int agentID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root rootItem = query.from(Item.class);
        Root rootOrder = query.from(OrderDetails.class);
        Root rootSalePost = query.from(SalePost.class);
        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = builder.equal(rootSalePost.get("agencyID"), agentID);
        predicates.add(p1);
        Predicate p2 = builder.equal(rootItem.get("postID"), rootSalePost.get("postID"));
        predicates.add(p2);
        Predicate p3 = builder.equal(rootItem.get("itemID"), rootOrder.get("itemID"));
        predicates.add(p3);
        query.where(predicates.toArray(new Predicate[]{}));
        query.select(builder.sum(rootOrder.get("quantity")).as(Integer.class));
        Query q = session.createQuery(query);
        return (int) q.getSingleResult();
    }

    @Override
    public List<Object[]> getTopSellerByAgencyID(int top, int agencyID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootItem = query.from(Item.class);
        Root rootOrder = query.from(OrderDetails.class);
        Root rootPost = query.from(SalePost.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p3 = builder.equal(rootPost.get("agencyID"), agencyID);
        predicates.add(p3);
        Predicate p1 = builder.equal(rootItem.get("itemID"), rootOrder.get("itemID"));
        predicates.add(p1);
        Predicate p2 = builder.equal(rootItem.get("postID"), rootPost.get("postID"));
        predicates.add(p2);
        query.where(predicates.toArray(new Predicate[]{}));
        query.multiselect(rootItem.get("avatar"),rootItem.get("itemID"), rootItem.get("name"), 
                rootItem.get("unitPrice"), builder.sum(rootOrder.get("quantity")), rootItem.get("description"),rootItem.get("inventory"));
        query.groupBy(rootItem.get("itemID"));
        query.orderBy(builder.desc(builder.sum(rootOrder.get("quantity"))));
        Query q = session.createQuery(query);
        q.setMaxResults(top);
        return q.getResultList();
    }

}
