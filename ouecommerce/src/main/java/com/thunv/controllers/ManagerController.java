/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.Agency;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.Orders;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.service.AgencyService;
import com.thunv.service.CommentService;
import com.thunv.service.ItemService;
import com.thunv.service.OrderDetailService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import com.thunv.validator.CommonAgencyValidator;
import com.thunv.validator.CommonSalePostValidator;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private CommentService commentService;
    @Autowired
    private Utils utils;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private CommonSalePostValidator salePostValidator;
    @Autowired
    private CommonAgencyValidator agencyValidator;
    @Autowired
    private Cloudinary cloudinary;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
            if (this.salePostValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(this.salePostValidator);
            }
            if (this.agencyValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(this.agencyValidator);
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
        return "manager";
    }

    @RequestMapping(value = "/revenue-stats")
    public String revenueStatsPage(Model model,
            @RequestParam(value = "year", required = false) String year) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        int yearStats;
        try {
            yearStats = Integer.parseInt(year);  
        } catch (Exception e) {
            yearStats = Calendar.getInstance().get(Calendar.YEAR);
        }
        String[] labelQuarter = {"Quarter 1st","Quarter 2nd","Quarter 3rd","Quarter 4th"};
        String[] labelMonth = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        model.addAttribute("revenueStatsMonth",
                this.utils.customListStatsMonth(this.salePostService.getStatsRevenueMonthByYear(yearStats, agency.getAgencyID())));
        model.addAttribute("revenueStatsQuarter",
                this.utils.customListStatsQuarter(this.salePostService.getStatsRevenueQuarterByYear(yearStats, agency.getAgencyID())));
        model.addAttribute("revenueStatsYear",this.salePostService.getStatsRevenueYear(agency.getAgencyID()));
        model.addAttribute("labelsQuarter",labelQuarter);
        model.addAttribute("labelsMonth",labelMonth);
        model.addAttribute("yearStats",yearStats);
        return "m-revenue-stats";
    }

    @RequestMapping(value = "/general-stats")
    public String genaralStatsPage(Model model, @RequestParam(value = "top", required = false, defaultValue = "10") String top) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
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
        model.addAttribute("topSeller", this.itemService.getTopSellerByAgencyID(topSeller, agency.getAgencyID()));
        model.addAttribute("countProducts", this.salePostService.countSalePostByAgentID(agency.getAgencyID()));
        model.addAttribute("countSold", this.itemService.countSoldByAgentID(agency.getAgencyID()));
        model.addAttribute("countLike", this.salePostService.countLikePostByAgentID(agency.getAgencyID()));
        model.addAttribute("countComment", this.commentService.countCommentByPostID(agency.getAgencyID()));
        model.addAttribute("avgStar", this.commentService.getAvarageStarByAgentID(agency.getAgencyID()));
        Map<Integer, List<OrderDetails>> result = this.utils.groupOrderByOrderID(this.orderDetailService.getListOrderDetailByAgentID(agency.getAgencyID()));
        model.addAttribute("listOrderDetail", result);
        model.addAttribute("statsByCategory", this.salePostService.getStatsSalePostByCategory(agency.getAgencyID()));
        return "m-general-stats";
    }

    @GetMapping(value = "/edit-agency")
    public String editAgencyPageView(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        model.addAttribute("currentAgent", agency);
        model.addAttribute("agent", new Agency());
        return "m-edit-agency";
    }

    @PostMapping(value = "/edit-agency")
    public String editAgencyPage(Model model, @ModelAttribute(value = "agent") @Valid Agency agency,
            BindingResult result) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency currentAgency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        model.addAttribute("currentAgent", currentAgency);

        if (!result.hasErrors() || result.getFieldErrors().size() == 1 && result.getFieldErrors().get(0).getField().toString().equals("fileAvatar")) {

            try {
                if (agency.getFileAvatarUpdate().isEmpty() == false) {
                    Map upload = this.cloudinary.uploader().upload(agency.getFileAvatarUpdate().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    currentAgency.setAvatar(upload.get("secure_url").toString());
                }
                currentAgency.setAddress(agency.getAddress());
                currentAgency.setName(agency.getName());
                currentAgency.setField(agency.getField());
                currentAgency.setHotline(agency.getHotline());
                if (this.agencyService.updateAgency(currentAgency) == true) {
                    return "redirect:/manager/edit-agency";
                } else {
                    String error_ms = "Update failed !!!";
                    model.addAttribute("err_ms", error_ms);
                }
            } catch (Exception e) {
            }
        }
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
                } else {
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
        model.addAttribute("listPostUnpublished", this.salePostService.getListSalePostUnpublished(agency.getAgencyID()));
        return "m-unpublished";
    }

    @RequestMapping(value = "/published-products")
    public String productPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        model.addAttribute("listPostPublished", this.salePostService.getListSalePostPublished(agency.getAgencyID()));
        return "m-published";
    }

    @GetMapping(value = "/edit-post/{postID}")
    public String editSalePostView(@PathVariable(value = "postID") String postID,
            Model model) {
        model.addAttribute("salePost", new SalePost());
        model.addAttribute("editSalePost", this.salePostService.getSalePostByID(Integer.parseInt(postID)));
        return "m-edit-post";
    }

    @PostMapping(value = "/edit-post/{postID}")
    public String editSalePost(@PathVariable(value = "postID") String postID,
            Model model, @ModelAttribute(value = "salePost") @Valid SalePost post,
            BindingResult result) {
        SalePost currentSalePost = this.salePostService.getSalePostByID(Integer.parseInt(postID));
        model.addAttribute("editSalePost", currentSalePost);
        if (!result.hasErrors() || result.getFieldErrors().size() == 1 && result.getFieldErrors().get(0).getField().toString().equals("fileAvatar")) {
            try {
                if (post.getFileAvatar().isEmpty() == false) {
                    Map upload = this.cloudinary.uploader().upload(post.getFileAvatar().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    currentSalePost.setAvatar(upload.get("secure_url").toString());
                }
                currentSalePost.setTitle(post.getTitle());
                currentSalePost.setSaleStatus(post.getSaleStatus());
                currentSalePost.setCategoryID(post.getCategoryID());
                currentSalePost.setOrigin(post.getOrigin());
                currentSalePost.setManufacturer(post.getManufacturer());
                currentSalePost.setDescription(post.getDescription());
                currentSalePost.setBrand(post.getBrand());
                currentSalePost.setFinalPrice(post.getFinalPrice());
                currentSalePost.setInitialPrice(post.getInitialPrice());
                if (this.salePostService.updateSalePost(currentSalePost) == true) {
                    return String.format("redirect:/manager/edit-post/%s", postID);
                } else {
                    String error_ms = "Update failed !!!";
                    model.addAttribute("err_ms", error_ms);
                }
            } catch (Exception e) {
            }
        }
        return "m-edit-post";
    }

    @RequestMapping(value = "/orders")
    public String orderPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        Agency agency = this.agencyService.getAgencyByUserID(currentUser.getUserID()).get(0);
        Map<Integer, List<OrderDetails>> result = this.utils.groupOrderByOrderID(this.orderDetailService.getListOrderDetailByAgentID(agency.getAgencyID()));
        model.addAttribute("listOrderDetail", result);
        return "m-orders";
    }
}
