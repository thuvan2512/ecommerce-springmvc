/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.PicturePost;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface PicturePostRepository {
    boolean addPicturePost(PicturePost picturePost);
    List<PicturePost> getPicturePostsByID(int picID);
    boolean deletePicturePost(PicturePost picturePost);
}
