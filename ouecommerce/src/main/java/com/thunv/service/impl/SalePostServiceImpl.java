/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.CommentPost;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.repository.SalePostRepository;
import com.thunv.service.SalePostService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;



/**
 *
 * @author thu.nv2512
 */
@Service
@PropertySource("classpath:messages.properties")
public class SalePostServiceImpl implements SalePostService{
    @Autowired
    private SalePostRepository salePostRepository;
    @Autowired
    private Environment env;

    @Override
    public List<SalePost> getListSalePost(Map<String, String> params, int page) {
        return this.salePostRepository.getListSalePost(params,page);
    }
    @Override
    public int countSalePost() {
        return this.salePostRepository.countSalePost();
    }

    @Override
    public int countPage() {
        int size = Integer.parseInt(env.getProperty("page.size").toString());
        int count = this.countSalePost();
        int result;
        if (size > 0 && count > 0) {
            result = (int)Math.round((double)(((count*1.0 / size*1.0) + 0.499999)));
        }else{
            result = 1;
        }
        return result;
    }

    @Override
    public SalePost getSalePostByID(int i) {
        return this.salePostRepository.getSalePostByID(i);
    }

    @Override
    public double getAverageStarRateByID(int i) {
        SalePost salepost = this.salePostRepository.getSalePostByID(i);
        int countRate = 0;
        int countStar = 0;
        for (CommentPost cp: salepost.getCommentPostSet()) {
            if (cp.getSupComment() == null && cp.getStarRate() != null) {
                countStar += cp.getStarRate();
                countRate++;
            }
        }
        if (countStar == 0) {
            return 0;
        }
        return (countStar * 1.0 )/ countRate;
    }

    @Override
    public List<SalePost> getListSalePostLikeByUser(User user) {
        return this.salePostRepository.getListSalePostLikeByUser(user);
    }

    @Override
    public int countSalePostByAgentID(int i) {
        return this.salePostRepository.countSalePostByAgentID(i);
    }

    @Override
    public int countLikePostByAgentID(int i) {
        return this.salePostRepository.countLikePostByAgentID(i);
    }

    @Override
    public boolean addEmptySalePost(SalePost sp) {
        sp.setIsActive(0);
        sp.setCreatedDate(new Date());
        return this.salePostRepository.addEmptySalePost(sp);
    }

    @Override
    public List<SalePost> getListSalePostUnpublished(int agentID) {
        return this.salePostRepository.getListSalePostUnpublished(agentID);
    }

    @Override
    public boolean publishSalePost(SalePost sp) {
        return this.salePostRepository.publishSalePost(sp);
    }

    @Override
    public boolean deleteSalePost(SalePost sp) {
        return this.salePostRepository.deleteSalePost(sp);
    }

    @Override
    public List<SalePost> getListSalePostPublished(int agentID) {
        return this.salePostRepository.getListSalePostPublished(agentID);
    }

    @Override
    public boolean updateSalePost(SalePost salePost) {
        return this.salePostRepository.updateSalePost(salePost);
    }

    @Override
    public List<Object[]> getStatsSalePostByCategory(int agencyID) {
        return this.salePostRepository.getStatsSalePostByCategory(agencyID);
    }

    @Override
    public List<Object[]> getStatsRevenueMonthByYear(int year, int agencyID) {
        return this.salePostRepository.getStatsRevenueMonthByYear(year, agencyID);
    }

    @Override
    public List<Object[]> getStatsRevenueQuarterByYear(int year, int agencyID) {
        return this.salePostRepository.getStatsRevenueQuarterByYear(year, agencyID);
    }

    @Override
    public List<Object[]> getStatsRevenueYear(int agencyID) {
        return this.salePostRepository.getStatsRevenueYear(agencyID);
    }

    @Override
    public List<Object[]> getStatsSalePostByCategory() {
        return this.salePostRepository.getStatsSalePostByCategory();
    }


}
