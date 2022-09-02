/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.CommentPost;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface CommentService {
    boolean addComment(CommentPost commentPost);
    List<CommentPost> getListCommentByPostID(int postID);
    int countCommentByPostID(int postID);
    int countLikePostByAgentID(int agentID);
    double getAvarageStarByAgentID(int agentID);
}
