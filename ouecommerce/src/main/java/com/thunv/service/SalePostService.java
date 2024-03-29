/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
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
    double getAverageStarRateByID(int id);
    List<SalePost> getListSalePostLikeByUser(User user);
    int countSalePostByAgentID(int agencyID);
    int countLikePostByAgentID(int agencyID);
    List<SalePost> getListSalePostUnpublished(int agentID);
    List<SalePost> getListSalePostPublished(int agentID);
    boolean addEmptySalePost(SalePost post);
    boolean publishSalePost(SalePost salePost);
    boolean updateSalePost(SalePost salePost);
    boolean deleteSalePost(SalePost salePost);
    List<Object[]> getStatsSalePostByCategory(int agencyID);
    List<Object[]> getStatsSalePostByCategory();
    List<Object[]> getStatsRevenueMonthByYear(int year, int agencyID);
    List<Object[]> getStatsRevenueQuarterByYear(int year, int agencyID);
    List<Object[]> getStatsRevenueYear(int agencyID);
    
}
