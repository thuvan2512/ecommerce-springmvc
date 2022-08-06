/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.pojo.SalePost;
import com.thunv.service.SalePostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu.nv2512
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private SalePostService salePostService;
    @GetMapping("/salepost/{salePostID}")
    public ResponseEntity<List<SalePost>> getSalePostByID(
            @PathVariable(value = "salePostID") String salePostID){
        List<SalePost>  listResults = new ArrayList<>();
        listResults.add(this.salePostService.getSalePostByID(Integer.parseInt(salePostID)));
        return new ResponseEntity<>(listResults,HttpStatus.OK);
    }
}
