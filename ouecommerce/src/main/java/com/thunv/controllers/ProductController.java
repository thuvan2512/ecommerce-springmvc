/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.service.SalePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
            @PathVariable(value = "productID") String productID) {
        model.addAttribute("product", this.salePostService.getSalePostByID(Integer.parseInt(productID)));
        double starAvg = this.salePostService.getAverageStarRateByID(Integer.parseInt(productID));
        int star = (int) Math.round((double) (starAvg - 0.5));
        int nonStar = 5 - (int) Math.round((double) (starAvg + 0.49999999));
        int haftStar = 5 - (nonStar + star);
        model.addAttribute("starAvg", starAvg);
        model.addAttribute("star", star);
        model.addAttribute("nonStar", nonStar);
        model.addAttribute("haftStar", haftStar);

        return "product-details";
    }

}
