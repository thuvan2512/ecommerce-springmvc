/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.LikePost;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface LikePostRepository {
    List<LikePost> getLikePostByUserID(int id);
    int addLikePost(User user, SalePost salePost);
    LikePost getLikePostExist(User user,SalePost salePost);
}
