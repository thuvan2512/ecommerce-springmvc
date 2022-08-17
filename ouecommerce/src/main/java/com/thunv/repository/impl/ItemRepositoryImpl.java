/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.Item;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.SalePost;
import com.thunv.repository.ItemRepository;
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
public class ItemRepositoryImpl implements ItemRepository{
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
        query = query.where(builder.equal(rootItem.get("itemID"), rootOrder.get("itemID")));
        query = query.multiselect(rootItem.get("itemID"),rootItem.get("postID").as(SalePost.class),rootItem.get("name"),
            rootItem.get("unitPrice"),builder.sum(rootOrder.get("quantity")));
        query = query.groupBy(rootItem.get("itemID"));
        query = query.orderBy(builder.desc(builder.sum(rootOrder.get("quantity"))));
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
    
}
