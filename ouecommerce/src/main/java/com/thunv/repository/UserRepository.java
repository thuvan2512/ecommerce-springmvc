/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.User;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface UserRepository {
    boolean checkExistUsername(String username);
    boolean checkExistEmail(String email);
    List<User> getUserByUsername(String username);
    List<User> getUserByEmail(String email);
    List<User> getUserByID(int id);
    boolean addUser(User user);
    boolean updateUser(User user);
}
