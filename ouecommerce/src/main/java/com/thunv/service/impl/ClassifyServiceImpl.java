/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.Classify;
import com.thunv.repository.ClassifyRepository;
import com.thunv.service.ClassifyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    private ClassifyRepository classifyRepository;

    @Override
    public List<Classify> getListClassifyByPostID(int postID) {
        return this.classifyRepository.getListClassifyByPostID(postID);
    }
    
}
