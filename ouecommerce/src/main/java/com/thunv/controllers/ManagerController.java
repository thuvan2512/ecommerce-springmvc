/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.Agency;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.service.AgencyService;
import com.thunv.service.ItemService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.validator.CommonSalePostValidator;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author thu.nv2512
 */
@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

    @Autowired
    private AgencyService agencyService;
    @Autowired
    private UserService userService;
    @Autowired
    private SalePostService salePostService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CommonSalePostValidator salePostValidator;
    @Autowired
    private Cloudinary cloudinary;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
            if (this.salePostValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(this.salePostValidator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/home")
    public String managerHomePage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        model.addAttribute("agency", agency);
        model.addAttribute("countProducts", this.salePostService.countSalePostByAgentID(agency.getAgencyID()));
        model.addAttribute("countSold", this.itemService.countSoldByAgentID(agency.getAgencyID()));
        model.addAttribute("countLike", this.salePostService.countLikePostByAgentID(agency.getAgencyID()));
        model.addAttribute("topSeller", this.itemService.getTopSellerByAgencyID(5, agency.getAgencyID()));
        return "manager";
    }

    @RequestMapping(value = "/revenue-stats")
    public String revenueStatsPage() {
        return "m-revenue-stats";
    }

    @RequestMapping(value = "/edit-agency")
    public String editAgencyPage() {
        return "m-edit-agency";
    }

    @RequestMapping(value = "/notifications")
    public String notificationPage() {
        return "m-notifications";
    }

    @GetMapping(value = "/add-product")
    public String addProductPage(Model model) {
        model.addAttribute("salePost", new SalePost());
        return "m-add-product";
    }

    @PostMapping(value = "/add-product")
    public String addProduct(Model model, @ModelAttribute(value = "salePost") @Valid SalePost post,
            BindingResult result) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        String err_ms = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        if (!result.hasErrors()) {
            try {
                Map upload = this.cloudinary.uploader().upload(post.getFileAvatar().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                post.setAvatar(upload.get("secure_url").toString());
                post.setAgencyID(this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0));
                if (this.salePostService.addEmptySalePost(post) == true) {
                    return "redirect:/manager/unpublished-products";
                }else{
                    err_ms = "Post failed !!!";
                }
            } catch (Exception e) {
                
                err_ms = "Post failed !!!";
                model.addAttribute("err_ms", err_ms);
                e.printStackTrace();
            }

        }
        return "m-add-product";
    }
    
    @RequestMapping(value = "/unpublished-products")
    public String unpublishedPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        System.err.println(agency.getAgencyID());
        System.err.println(this.salePostService.getListSalePostUnpublished(agency.getAgencyID()));
        model.addAttribute("listPostUnpublished",this.salePostService.getListSalePostUnpublished(agency.getAgencyID()));
        return "m-unpublished";
    }

    @RequestMapping(value = "/products")
    public String productPage() {
        return "m-products";
    }

    @RequestMapping(value = "/unconfirmed-orders")
    public String unOrderPage() {
        return "m-un-orders";
    }

    @RequestMapping(value = "/orders")
    public String orderPage() {
        return "m-orders";
    }
}
