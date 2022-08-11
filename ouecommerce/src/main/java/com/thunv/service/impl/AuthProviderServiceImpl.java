/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.AuthProvider;
import com.thunv.repository.AuthProviderRepository;
import com.thunv.service.AuthProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class AuthProviderServiceImpl implements AuthProviderService{
    @Autowired
    private AuthProviderRepository authProviderRepository;
    @Override
    public AuthProvider getAuthProviderByID(int id) {
        return this.authProviderRepository.getAuthProviderByID(id);
    }
    
}
