/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.User;
import com.thunv.service.UserService;
import com.thunv.validator.CommonUserValidator;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thunv.validator.user.UsernameValidator;

/**
 *
 * @author thu.nv2512
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserService userService;
    @Autowired
    private CommonUserValidator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping(value = "/sign-up")
    public String signUpView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("err_ms", null);
        return "signup";
    }

    @PostMapping(value = "/sign-up")
    public String signUp(Model model,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        if (!result.hasErrors()) {
            try {
                Map upload = this.cloudinary.uploader().upload(user.getFileAvatar().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                System.out.println(upload.get("secure_url").toString());
                user.setAvatar(upload.get("secure_url").toString());
                if (this.userService.addUser(user) == true) {
                    return "redirect:/user/sign-in";
                }
            } catch (Exception ex) {
                String err_ms;
                err_ms = "Sign up failed !!!";
                model.addAttribute("err_ms", err_ms);
            }
        }
        return "signup";
    }

    @GetMapping(value = "/sign-in")
    public String signInView() {
        return "signin";
    }
}
