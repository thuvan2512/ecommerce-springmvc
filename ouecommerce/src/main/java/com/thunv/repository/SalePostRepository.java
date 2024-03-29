/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import java.util.List;
import java.util.Map;


/**
 *
 * @author thu.nv2512
 */

public interface SalePostRepository {
    List<SalePost> getListSalePost(Map<String, String> params, int page);
    int countSalePost();
    SalePost getSalePostByID(int id);
    List<SalePost> getListSalePostLikeByUser(User user);
    int countSalePostByAgentID(int agencyID);
    int countLikePostByAgentID(int agencyID);
    boolean addEmptySalePost(SalePost post);
    List<SalePost> getListSalePostUnpublished(int agentID);
    List<SalePost> getListSalePostPublished(int agentID);
    boolean publishSalePost(SalePost salePost);
    boolean updateSalePost(SalePost salePost);
    boolean deleteSalePost(SalePost salePost);
    List<Object[]> getStatsSalePostByCategory(int agencyID);
    List<Object[]> getStatsSalePostByCategory();
    List<Object[]> getStatsRevenueMonthByYear(int year,int agencyID);
    List<Object[]> getStatsRevenueQuarterByYear(int year,int agencyID);
    List<Object[]> getStatsRevenueYear(int agencyID);
}
