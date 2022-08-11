/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.service.SalePostService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu.nv2512
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private SalePostService salePostService;
    @GetMapping(value = "/product-details/{productID}")
    public String productDetails(Model model,
            @PathVariable(value = "productID") String productID){
        model.addAttribute("product",this.salePostService.getSalePostByID(Integer.parseInt(productID)));
        return "product-details";
    }
}
