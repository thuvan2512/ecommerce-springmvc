/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.Item;
import com.thunv.pojo.LikePost;
import com.thunv.pojo.OrderDetails;
import com.thunv.subentity.Cart;
import com.thunv.pojo.User;
import com.thunv.service.AgencyService;
import com.thunv.service.AuthProviderService;
import com.thunv.service.CategoryService;
import com.thunv.service.CommentService;
import com.thunv.service.FieldAgentService;
import com.thunv.service.ItemService;
import com.thunv.service.LikePostService;
import com.thunv.service.MailService;
import com.thunv.service.OrderDetailService;
import com.thunv.service.SalePostService;
import com.thunv.service.SaleStatusService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import com.thunv.validator.CommonAgencyValidator;
import com.thunv.validator.CommonUserValidator;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu.nv2512
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private SalePostService salePostService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private Utils utils;
    @Autowired
    private LikePostService likePostService;
    @Autowired
    private AgencyService agencyService;
    @Autowired
    private CommonUserValidator userValidator;
    @Autowired
    private AuthProviderService authProviderService;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private FieldAgentService fieldAgentService;
    @Autowired
    private SaleStatusService saleStatusService;

    @ModelAttribute
    public void commonAttribute(Model model, HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
            model.addAttribute("currentUser", currentUser);
        }
        if (username != "") {
            model.addAttribute("wishlist", this.likePostService.getLikePostByUserID(currentUser.getUserID()));
            model.addAttribute("listPostInWishlist", this.salePostService.getListSalePostLikeByUser(currentUser));
            model.addAttribute("listSaleStatus", this.saleStatusService.getListSaleStatus());
//            System.err.println(this.salePostService.getListSalePostLikeByUser(currentUser));
        } else {
            model.addAttribute("wishlist", null);
        }
        model.addAttribute("field",this.fieldAgentService.getListAgentFields());
        model.addAttribute("listCategories", this.categoryService.getListCategories());
        model.addAttribute("countCart", this.utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }

    @RequestMapping(value = "/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("page", page);
        model.addAttribute("countPage", this.salePostService.countPage());
        model.addAttribute("listSalePost", this.salePostService.getListSalePost(params, page));
        model.addAttribute("listAgency",this.agencyService.getTopAgency(4));
        return "index";
    }

    @GetMapping(value = "/search")
    public String search(Model model, HttpServletRequest request) {
        model.addAttribute("currentURL", request.getRequestURL().toString());
        model.addAttribute("currentParams", "&" + this.utils.removePageParams(request.getQueryString()));
        return "forward:/";
    }

    @GetMapping(value = "/cart")
    public String cartPage(Model model,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        model.addAttribute("topSeller", this.itemService.getTopSeller(2));
        model.addAttribute("carts", cart.values());
        model.addAttribute("totalPrice", this.utils.getTotalPriceCart(cart));
//        System.err.println(this.itemService.getTopSeller(2).get(0)[1]);
        return "cart";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
            if (this.userValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(this.userValidator);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/sign-up")
    public String signUpView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("err_ms", null);
        return "signup";
    }

    @PostMapping(value = "/sign-up")
    public String signUp(Model model,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        if (!result.hasErrors()) {
            try {
                Map upload = this.cloudinary.uploader().upload(user.getFileAvatar().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                System.out.println(upload.get("secure_url").toString());
                user.setAvatar(upload.get("secure_url").toString());
                user.setAuthProvider(this.authProviderService.getAuthProviderByID(1));
                if (this.userService.addUser(user) == true) {
                    return "redirect:/sign-in";
                }
            } catch (Exception ex) {
                String err_ms;
                err_ms = "Sign up failed !!!";
                model.addAttribute("err_ms", err_ms);
            }
        }
        return "signup";
    }

    @GetMapping(value = "/sign-in")
    public String signInView() {
        return "signin";
    }
    
    @GetMapping(value = "/agency/{agencyID}")
    public String signInView(@PathVariable(value = "agencyID") String agencyID, Model model) {
        int agentID;
        try {
            agentID = Integer.parseInt(agencyID);
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
        model.addAttribute("agency",this.agencyService.getAgencyByID(agentID).get(0));
        model.addAttribute("countProducts", this.salePostService.countSalePostByAgentID(agentID));
        model.addAttribute("countSold", this.itemService.countSoldByAgentID(agentID));
        model.addAttribute("countLike", this.salePostService.countLikePostByAgentID(agentID));
        model.addAttribute("countComment", this.commentService.countCommentByPostID(agentID));
        model.addAttribute("avgStar", this.commentService.getAvarageStarByAgentID(agentID));
        Map<Integer, List<OrderDetails>> result = this.utils.groupOrderByOrderID(this.orderDetailService.getListOrderDetailByAgentID(agentID));
        model.addAttribute("listOrderDetail", result);
        model.addAttribute("listPostAgency",this.salePostService.getListSalePostPublished(agentID));
        return "agency-detail";
    }

}
