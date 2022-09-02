/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.CommentPost;
import com.thunv.repository.CommentRepository;
import com.thunv.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public boolean addComment(CommentPost commentPost) {
        commentPost.setCreatedDate(new Date());
        return this.commentRepository.addComment(commentPost);
    }

    @Override
    public List<CommentPost> getListCommentByPostID(int i) {
        return this.commentRepository.getListCommentByPostID(i);
    }

    @Override
    public int countCommentByPostID(int i) {
        return this.commentRepository.countCommentByPostID(i);
    }

    @Override
    public int countLikePostByAgentID(int agentID) {
        return this.commentRepository.countCommentByPostID(agentID);
    }

    @Override
    public double getAvarageStarByAgentID(int agentID) {
        return this.commentRepository.getAvarageStarByAgentID(agentID);
    }
    
}
