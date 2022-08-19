/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.LikePost;
import com.thunv.subentity.Cart;
import com.thunv.pojo.User;
import com.thunv.service.CategoryService;
import com.thunv.service.ItemService;
import com.thunv.service.LikePostService;
import com.thunv.service.MailService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu.nv2512
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private SalePostService salePostService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private Utils utils;
    @Autowired
    private LikePostService likePostService;

    @ModelAttribute
    public void commonAttribute(Model model, HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
            model.addAttribute("currentUser", currentUser);
        }
        if (username != "") {
            model.addAttribute("wishlist", this.likePostService.getLikePostByUserID(currentUser.getUserID()));
            model.addAttribute("listPostInWishlist",this.salePostService.getListSalePostLikeByUser(currentUser));
//            System.err.println(this.salePostService.getListSalePostLikeByUser(currentUser));
        } else {
            model.addAttribute("wishlist", null);
        }

        model.addAttribute("listCategories", this.categoryService.getListCategories());
        model.addAttribute("countCart", this.utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }

    @RequestMapping(value = "/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("page", page);
        model.addAttribute("countPage", this.salePostService.countPage());
        model.addAttribute("listSalePost", this.salePostService.getListSalePost(params, page));
        return "index";
    }

    @GetMapping(value = "/search")
    public String search(Model model, HttpServletRequest request) {
        model.addAttribute("currentURL", request.getRequestURL().toString());
        model.addAttribute("currentParams", "&" + this.utils.removePageParams(request.getQueryString()));
        return "forward:/";
    }

    @GetMapping(value = "/cart")
    public String cartPage(Model model,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        model.addAttribute("topSeller", this.itemService.getTopSeller(2));
        model.addAttribute("carts", cart.values());
        model.addAttribute("totalPrice", this.utils.getTotalPriceCart(cart));
//        System.err.println(this.itemService.getTopSeller(2).get(0)[1]);
        return "cart";
    }

}
