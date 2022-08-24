/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.Role;
import com.thunv.pojo.User;
import com.thunv.repository.UserRepository;
import com.thunv.service.RoleService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DatetimeExpressionBNF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Utils utils;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean checkExistUsername(String username) {
        return this.userRepository.checkExistUsername(username);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return this.userRepository.checkExistEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUserByUsername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist!");
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public List<User> getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean addUser(User user) {
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(password));
        user.setRole(this.roleService.getRoleByID(5));
        user.setJoinedDate(new Date());
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getUserByID(int i) {
        return this.userRepository.getUserByID(i);
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getRePassword() != null) {
            String password = user.getRePassword();
            user.setPassword(this.passwordEncoder.encode(password));
        }
        return this.userRepository.updateUser(user);
    }

}
