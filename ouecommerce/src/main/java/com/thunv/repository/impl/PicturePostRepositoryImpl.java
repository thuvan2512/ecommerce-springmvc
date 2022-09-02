/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository.impl;

import com.thunv.pojo.PicturePost;
import com.thunv.repository.PicturePostRepository;
import java.util.List;
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
public class PicturePostRepositoryImpl implements PicturePostRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public boolean addPicturePost(PicturePost picturePost) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            session.save(picturePost);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List<PicturePost> getPicturePostsByID(int picID) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createNamedQuery("PicturePost.findByPicID");
        query.setParameter("picID", picID);
        return query.getResultList();
    }

    @Override
    public boolean deletePicturePost(PicturePost picturePost) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            session.delete(picturePost);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
