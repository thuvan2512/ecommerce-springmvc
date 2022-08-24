/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author thu.nv2512
 */
public interface UserService extends UserDetailsService {

    boolean checkExistUsername(String username);

    boolean checkExistEmail(String email);

    List<User> getUserByUsername(String username);
    
    List<User> getUserByEmail(String email);
    List<User> getUserByID(int id);

    boolean addUser(User user);
    boolean updateUser(User user);
    
}
