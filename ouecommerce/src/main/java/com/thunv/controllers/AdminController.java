/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.pojo.Agency;
import com.thunv.pojo.OrderDetails;
import com.thunv.service.AgencyService;
import com.thunv.service.CommentService;
import com.thunv.service.ItemService;
import com.thunv.service.OrderDetailService;
import com.thunv.service.OrderService;
import com.thunv.service.OrderStateService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import java.util.Calendar;
import java.util.List;
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
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AgencyService agencyService;
    @Autowired
    private SalePostService salePostService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderStateService orderStateService;
    @Autowired
    private Utils utils;

    @GetMapping(value = "/home")
    public String adminPage(Model model) {
        model.addAttribute("countItem", this.itemService.countItem());
        model.addAttribute("countUser", this.userService.countUser());
        model.addAttribute("countPost", this.salePostService.countSalePost());
        model.addAttribute("countAgency", this.agencyService.countAgency());
        model.addAttribute("countOrder", this.orderService.countOrder());
        return "admin";
    }

    @RequestMapping(value = "/notifications")
    public String notificationPage() {
        return "a-notifications";
    }

    @RequestMapping(value = "/orders")
    public String ordersPage(Model model) {
        model.addAttribute("listOrder", this.orderService.getListOrder());
        model.addAttribute("listOrderState", this.orderStateService.getListOrderState());
        return "a-orders";
    }

    @RequestMapping(value = "/agency")
    public String agencyPage(Model model) {
        model.addAttribute("listAgency", this.agencyService.getListAgencyByActive(1));
        return "a-agency";
    }

    @RequestMapping(value = "/agency-stats/{agencyID}")
    public String agencyStatsPage(Model model, @PathVariable(value = "agencyID") String agencyID, @RequestParam(value = "top", required = false, defaultValue = "10") String top) {
        int agentID = Integer.parseInt(agencyID);
        int topSeller;
        try {
            topSeller = Integer.parseInt(top);
            if (topSeller > 10 || topSeller < 0) {
                topSeller = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            topSeller = 10;
        }
        model.addAttribute("agency", this.agencyService.getAgencyByID(agentID).get(0));
        model.addAttribute("countProducts", this.salePostService.countSalePostByAgentID(agentID));
        model.addAttribute("countSold", this.itemService.countSoldByAgentID(agentID));
        model.addAttribute("countLike", this.salePostService.countLikePostByAgentID(agentID));
        model.addAttribute("countComment", this.commentService.countCommentByPostID(agentID));
        model.addAttribute("avgStar", this.commentService.getAvarageStarByAgentID(agentID));
        Map<Integer, List<OrderDetails>> result = this.utils.groupOrderByOrderID(this.orderDetailService.getListOrderDetailByAgentID(agentID));
        model.addAttribute("listOrderDetail", result);
        model.addAttribute("topSeller", this.itemService.getTopSellerByAgencyID(topSeller, agentID));
        model.addAttribute("statsByCategory", this.salePostService.getStatsSalePostByCategory(agentID));
        return "a-agency-stats";
    }

    @RequestMapping(value = "/censorship")
    public String censorshipPage(Model model) {
        model.addAttribute("listCensorship", this.agencyService.getListAgencyNeedCensorship());
        return "a-censorship";
    }

    @RequestMapping(value = "/banned-agency")
    public String bannedAgencyPage(Model model) {
        model.addAttribute("listAgencyBanned", this.agencyService.getListAgencyByActive(0));
        return "a-agency-banned";
    }

    @RequestMapping(value = "/general-stats")
    public String generalStatsPage(Model model, @RequestParam(value = "top", required = false, defaultValue = "10") String top,
             @RequestParam(value = "topAgency", required = false, defaultValue = "10") String topAgency,
             @RequestParam(value = "year", required = false, defaultValue = "2022") String year,
             @RequestParam(value = "quarter", required = false, defaultValue = "1") String quarter) {
        int topSeller;
        int topAgent;
        int yearInput;
        int quarterInput;
        try {
            yearInput = Integer.parseInt(year);
            quarterInput = Integer.parseInt(quarter);
            topAgent =  Integer.parseInt(topAgency);
            topSeller = Integer.parseInt(top);
            if (topSeller > 10 || topSeller < 0) {
                topSeller = 0;
            }
            if (topAgent > 10 || topAgent < 0) {
                topAgent = 0;
            }
            if (quarterInput < 1 || quarterInput > 4) {
                quarterInput = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            yearInput = Calendar.getInstance().get(Calendar.YEAR);
            quarterInput = 1;
            topSeller = 10;
            topAgent = 10;
        }
        model.addAttribute("statsByCategory", this.salePostService.getStatsSalePostByCategory());
        model.addAttribute("topSeller",this.itemService.getTopSeller(topSeller));
        model.addAttribute("countProducts",this.salePostService.countSalePost());
        model.addAttribute("saleFrequency", this.agencyService.getStatsSaleFrequency(topAgent,yearInput, quarterInput));
        return "a-general-stats";
    }
}
