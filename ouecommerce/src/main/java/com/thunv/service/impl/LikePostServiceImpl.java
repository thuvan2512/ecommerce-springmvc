/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.LikePost;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.repository.LikePostRepository;
import com.thunv.service.LikePostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class LikePostServiceImpl implements LikePostService{
    @Autowired
    private LikePostRepository likePostRepository;

    @Override
    public List<LikePost> getLikePostByUserID(int id) {
        return this.likePostRepository.getLikePostByUserID(id);
    }

    @Override
    public int addLikePost(User user, SalePost salePost) {
        return this.likePostRepository.addLikePost(user, salePost);
    }
    
    
}
