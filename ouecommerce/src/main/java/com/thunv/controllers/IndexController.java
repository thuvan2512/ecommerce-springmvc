/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author thu.nv2512
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping(value = "/")
    public String index(Model model){
        List<String> listCategories = new ArrayList<>();
        listCategories.add("Cate 1");
        listCategories.add("Cate 2");
        listCategories.add("Cate 3");
        listCategories.add("Cate 4");
        listCategories.add("Cate 5");
        listCategories.add("Cate 6");
        model.addAttribute("categories",listCategories);
        return "index";
    }
    
    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
