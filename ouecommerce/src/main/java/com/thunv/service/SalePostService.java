/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.SalePost;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu.nv2512
 */
public interface SalePostService {
    List<SalePost> getListSalePost(Map<String, String> params, int page);
    int countSalePost();
    int countPage();
    SalePost getSalePostByID(int id);
}
