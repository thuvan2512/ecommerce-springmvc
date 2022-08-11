/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.AuthProvider;

/**
 *
 * @author thu.nv2512
 */
public interface AuthProviderRepository {
    AuthProvider getAuthProviderByID(int id);
}
