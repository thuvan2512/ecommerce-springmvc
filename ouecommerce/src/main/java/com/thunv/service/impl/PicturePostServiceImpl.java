/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.PicturePost;
import com.thunv.repository.PicturePostRepository;
import com.thunv.service.PicturePostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class PicturePostServiceImpl implements PicturePostService{
    @Autowired 
    private PicturePostRepository picturePostRepository;

    @Override
    public boolean addPicturePost(PicturePost picturePost) {
        return this.picturePostRepository.addPicturePost(picturePost);
    }

    @Override
    public List<PicturePost> getPicturePostsByID(int picID) {
        return this.picturePostRepository.getPicturePostsByID(picID);
    }

    @Override
    public boolean deletePicturePost(PicturePost picturePost) {
        return this.picturePostRepository.deletePicturePost(picturePost);
    }
    
}
