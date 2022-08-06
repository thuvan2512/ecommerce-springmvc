/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.SalePost;
import com.thunv.repository.SalePostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu.nv2512
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class SalePostRepositoryImpl implements SalePostRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private Environment env;
    @Override
    public List<SalePost> getListSalePost(Map<String, String> params, int page) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SalePost> criteriaQuery = criteriaBuilder.createQuery(SalePost.class);
        Root root = criteriaQuery.from(SalePost.class);
        criteriaQuery.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = criteriaBuilder.like(root.get("title").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }
            String category = params.get("category");
            if (category != null && !category.isEmpty() && !category.equals("all")) {
                Predicate p = criteriaBuilder.equal(root.get("categoryID"), Integer.parseInt(category));
                predicates.add(p);
            }

//            String fp = params.get("fromPrice");
//            if (fp != null) {
//                Predicate p = criteriaBuilder.greaterThanOrEqualTo(root.get("price").as(Long.class), Long.parseLong(fp));
//                predicates.add(p);
//            }
//
//            String tp = params.get("toPrice");
//            if (tp != null) {
//                Predicate p = criteriaBuilder.lessThanOrEqualTo(root.get("price").as(Long.class), Long.parseLong(tp));
//                predicates.add(p);
//            }
//
//            String cateId = params.get("cateId");
//            if (cateId != null) {
//                Predicate p = criteriaBuilder.equal(root.get("categoryId"), Integer.parseInt(cateId));
//                predicates.add(p);
//            }

            criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        }
        Query query = session.createQuery(criteriaQuery);
        if(page < 0){
            page = 1;
        }
        if (page != 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }
    
    @Override
    public int countSalePost() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM SalePost");

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public SalePost getSalePostByID(int i) {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
       Query query = session.createNamedQuery("SalePost.findByPostID");
       query.setParameter("postID", i);
       return (SalePost) query.getSingleResult();
    }
    
}
