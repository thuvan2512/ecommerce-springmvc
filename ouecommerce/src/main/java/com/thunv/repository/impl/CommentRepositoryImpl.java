/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.CommentPost;
import com.thunv.pojo.SalePost;
import com.thunv.repository.CommentRepository;
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
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public boolean addComment(CommentPost commentPost) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(commentPost);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<CommentPost> getListCommentByPostID(int postID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CommentPost> query = builder.createQuery(CommentPost.class);
        Root root = query.from(CommentPost.class);
        query.select(root);
        query.where(builder.equal(root.get("postID"), postID));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public int countCommentByPostID(int i) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root root = query.from(CommentPost.class);
        query.select(builder.count(root.get("postID")).as(Integer.class));
        query.where(builder.equal(root.get("postID"), i));
        Query q = session.createQuery(query);
        return (int) q.getSingleResult();
    }

    @Override
    public int countLikePostByAgentID(int agentID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root rootComment = query.from(CommentPost.class);
        Root rootSalePost = query.from(SalePost.class);
        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = builder.equal(rootSalePost.get("agencyID"), agentID);
        predicates.add(p1);
        Predicate p2 = builder.equal(rootComment.get("postID"), rootSalePost.get("postID"));
        predicates.add(p2);
        query.where(predicates.toArray(new Predicate[]{}));
        query.select(builder.count(rootComment.get("commentID")).as(Integer.class));
        Query q = session.createQuery(query);
        return (int) q.getSingleResult();
    }

    @Override
    public double getAvarageStarByAgentID(int agentID) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root rootComment = query.from(CommentPost.class);
            Root rootSalePost = query.from(SalePost.class);
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = builder.equal(rootSalePost.get("agencyID"), agentID);
            predicates.add(p1);
            Predicate p2 = builder.equal(rootComment.get("postID"), rootSalePost.get("postID"));
            predicates.add(p2);
            query.where(predicates.toArray(new Predicate[]{}));
            query.select(builder.avg(rootComment.get("starRate").as(Integer.class)));
            Query q = session.createQuery(query);
            double result = (double) q.getSingleResult();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
