/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.CommentPost;
import com.thunv.repository.CommentRepository;
import org.hibernate.Session;
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
public class CommentRepositoryImpl implements CommentRepository{
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
    
}
