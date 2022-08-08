/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.User;
import com.thunv.service.CategoryService;
import com.thunv.service.MailService;
import com.thunv.service.SalePostService;
import com.thunv.utils.Utils;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Utils utils;

    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("listCategories", this.categoryService.getListCategories());
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
        model.addAttribute("currentURL",request.getRequestURL().toString());
        model.addAttribute("currentParams","&" + this.utils.removePageParams(request.getQueryString())) ;
        return "forward:/";
    }
    
}
