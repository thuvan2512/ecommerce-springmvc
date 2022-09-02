/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.pojo.User;
import com.thunv.service.UserService;
import com.thunv.subentity.Cart;
import com.thunv.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author thu.nv2512
 */
@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private UserService userService;
    @Autowired
    private Utils utils;
    @GetMapping
    public String paymentPage(HttpSession session,Model model){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        User currentUser = null;
        if (!this.userService.getUserByUsername(username).isEmpty()) {
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        if (cart != null && currentUser != null) {
            model.addAttribute("cart",cart.values());
            model.addAttribute("customer",currentUser);
            model.addAttribute("countItems",this.utils.countCart(cart));
            model.addAttribute("total",this.utils.getTotalPriceCart(cart));
            return "payment";
        }
        return "redirect:/cart"; 
    }
    @GetMapping(value = "/result")
    public String paymentResult(){
        return "payment-result";
    }
}
