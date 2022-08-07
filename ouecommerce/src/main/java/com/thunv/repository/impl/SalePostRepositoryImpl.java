/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.SalePost;
import com.thunv.repository.SalePostRepository;
import com.thunv.utils.Utils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SalePostRepositoryImpl implements SalePostRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private Utils utils;
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

            String fp = params.get("fprice");
            if (fp != null && !fp.isEmpty()) {
                Predicate p = criteriaBuilder.greaterThanOrEqualTo(root.get("finalPrice").as(Double.class), Double.parseDouble(fp));
                predicates.add(p);
            }

            String tp = params.get("tprice");
            if (tp != null && !tp.isEmpty()) {
                Predicate p = criteriaBuilder.lessThanOrEqualTo(root.get("finalPrice").as(Double.class), Double.parseDouble(tp));
                predicates.add(p);
            }
            String fdate = params.get("fdate");
            if (fdate != null && !fdate.isEmpty()) {
                Predicate p;
                try {
                    p = criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate").as(Date.class), this.utils.getSimpleDateFormat().parse(fdate));
                    predicates.add(p);
                } catch (ParseException ex) {
                    Logger.getLogger(SalePostRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String tdate = params.get("tdate");
            if (tdate != null && !tdate.isEmpty()) {
                Predicate p;
                try {
                    p = criteriaBuilder.lessThanOrEqualTo(root.get("createdDate").as(Date.class), this.utils.getSimpleDateFormat().parse(tdate));
                    predicates.add(p);
                } catch (ParseException ex) {
                    Logger.getLogger(SalePostRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            String instock = params.get("instock");
            if (instock != null && !instock.isEmpty()) {
                Predicate p = criteriaBuilder.equal(root.get("saleStatus"), 1);
                predicates.add(p);
            }
            String bestseller = params.get("bestseller");
            if (bestseller != null && !bestseller.isEmpty()) {
                Predicate p = criteriaBuilder.equal(root.get("saleStatus"), 2);
                predicates.add(p);
            }
            String trending = params.get("trending");
            if (trending != null && !trending.isEmpty()) {
                Predicate p = criteriaBuilder.equal(root.get("saleStatus"), 6);
                predicates.add(p);
            }
            String superpromo = params.get("superpromo");
            if (superpromo != null && !superpromo.isEmpty()) {
                Predicate p = criteriaBuilder.equal(root.get("saleStatus"), 4);
                predicates.add(p);
            }
            String freeship = params.get("freeship");
            if (freeship != null && !freeship.isEmpty()) {
                Predicate p = criteriaBuilder.equal(root.get("saleStatus"), 5);
                predicates.add(p);
            }
            String promotion = params.get("promotion");
            if (promotion != null && !promotion.isEmpty()) {
                Predicate p = criteriaBuilder.equal(root.get("saleStatus"), 3);
                predicates.add(p);
            }
//instock=1&bestseller=1&new=1&promotion=1&freeship=1&superpromo=1
//            String cateId = params.get("cateId");
//            if (cateId != null) {
//                Predicate p = criteriaBuilder.equal(root.get("categoryId"), Integer.parseInt(cateId));
//                predicates.add(p);
//            }

            criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        }
        Query query = session.createQuery(criteriaQuery);
        if (page < 0) {
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
