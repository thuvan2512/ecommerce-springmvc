/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.subentity.GoogleInfo;
import com.thunv.service.UserService;
import com.thunv.social.FacebookUtils;
import com.thunv.social.GoogleUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author thu.nv2512
 */
@Controller
public class SocialLoginController {

    @Autowired
    private GoogleUtils googleUtils;
    @Autowired
    private FacebookUtils facebookUtils;
    @Autowired
    private UserService userService;

    @GetMapping("/login-google")
    public String loginGoogle(Model model,
            HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/user/sign-in?error";
        }
        String accessToken = googleUtils.getToken(code);
        GoogleInfo googleInfo = googleUtils.getUserInfo(accessToken);
        if (this.userService.checkExistEmail(googleInfo.getEmail()) != true) {
            this.googleUtils.createUser(googleInfo);
            UserDetails userDetail = googleUtils.buildUser(this.userService.getUserByEmail(googleInfo.getEmail()).get(0));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/";
        } else {
            int auth = this.userService.getUserByEmail(googleInfo.getEmail()).get(0).getAuthProvider().getAuthID();
            if (auth == 2) {
                UserDetails userDetail = googleUtils.buildUser(this.userService.getUserByEmail(googleInfo.getEmail()).get(0));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return "redirect:/";
            } else {
                model.addAttribute("err_ms", "email failed");
            }
            return "forward:/user/sign-in?error";
        }
    }

    @GetMapping("/login-facebook")
    public String loginFacebook(Model model, HttpServletRequest request) {
        String code = request.getParameter("code");
        String accessToken = "";
        try {
            accessToken = facebookUtils.getToken(code);
        } catch (Exception e) {
            return "redirect:/user/sign-in?error";
        }
        com.restfb.types.User facebookInfo = facebookUtils.getUserInfo(accessToken);
        System.err.println("\n \n \n" + facebookInfo.getName() + "\n" + facebookInfo.toString() + "\n \n \n");
        if (this.userService.checkExistEmail(facebookInfo.getEmail()) != true) {
            this.facebookUtils.createUser(facebookInfo);
            UserDetails userDetail = this.facebookUtils.buildUser(this.userService.getUserByEmail(facebookInfo.getEmail()).get(0));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/";
        } else {
            int auth = this.userService.getUserByEmail(facebookInfo.getEmail()).get(0).getAuthProvider().getAuthID();
            if (auth == 3) {
                UserDetails userDetail = this.facebookUtils.buildUser(this.userService.getUserByEmail(facebookInfo.getEmail()).get(0));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return "redirect:/";
            } else {
                model.addAttribute("err_ms", "email failed");
            }
            return "forward:/user/sign-in?error";
        }
    }
}
