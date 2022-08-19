/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.LikePost;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.repository.LikePostRepository;
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
public class LikePostRepositoryImpl implements LikePostRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<LikePost> getLikePostByUserID(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LikePost> query = builder.createQuery(LikePost.class);
        Root root = query.from(LikePost.class);
        query.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = builder.equal(root.get("userID"), id);
        predicates.add(p1);
        Predicate p2 = builder.equal(root.get("state").as(Integer.class), 1);
        predicates.add(p2);
        query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public int addLikePost(User user, SalePost salePost) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            LikePost lp = this.getLikePostExist(user, salePost);
            if (lp != null) {
                if (lp.getState() == 1) {
                    lp.setState(0);
                } else {
                    lp.setState(1);
                }
                session.save(lp);
                return lp.getState();
            } else {
                LikePost likePost = new LikePost();
                likePost.setPostID(salePost);
                likePost.setUserID(user);
                likePost.setState(1);
                session.save(likePost);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public LikePost getLikePostExist(User user, SalePost salePost) {
        LikePost likePost;
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<LikePost> query = builder.createQuery(LikePost.class);
            Root root = query.from(LikePost.class);
            query.select(root);
            List<Predicate> predicates = new ArrayList<>();
            Predicate p1 = builder.equal(root.get("userID"), user);
            predicates.add(p1);
            Predicate p2 = builder.equal(root.get("postID"), salePost);
            predicates.add(p2);
            query.where(predicates.toArray(new Predicate[]{}));
            Query q = session.createQuery(query);
            likePost = (LikePost) q.getSingleResult();
        } catch (Exception e) {
            likePost = null;
            e.printStackTrace();
        }
        return likePost;
    }

}
