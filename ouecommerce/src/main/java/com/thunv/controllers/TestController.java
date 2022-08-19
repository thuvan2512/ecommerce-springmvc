/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.CommentPost;
import com.thunv.pojo.LikePost;
import com.thunv.pojo.Orders;
import com.thunv.subentity.GoogleInfo;
import com.thunv.pojo.User;
import com.thunv.service.ClassifyService;
import com.thunv.service.LikePostService;
import com.thunv.service.MailService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.social.GoogleUtils;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.http.client.ClientProtocolException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author thu.nv2512
 */
@Controller
public class TestController {

    @Autowired
    private MailService mailService;
    @Autowired
    private SalePostService salePostService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoogleUtils googleUtils;
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private LikePostService likePostService;

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
//        String code = request.getParameter("code");
//
//        if (code == null || code.isEmpty()) {
//            return "redirect:/login?message=google_error";
//        }
//        String accessToken = googleUtils.getToken(code);
//
//        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
//        UserDetails userDetail = googleUtils.buildUser(googlePojo);
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
//                userDetail.getAuthorities());
//        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "test";
    }

    @GetMapping(value = "/sendmail")
    public String sendMail() {
//        String mailTo = "1951052056hieu@ou.edu.vn";
//        String subject = "Thank you for shopping at OU ecommerce";
//        String title = "Dear Hieu,";
//        String content = "We have received your order";
//        String mailTemplate = "mail";
//        this.mailService.sendMail(mailTo, subject, title, content, mailTemplate);
        return "index";
    }

    @GetMapping(value = "/test")
//    @Transactional
    public String test(Model model) {
        model.addAttribute("userTest", new User());
        System.err.println(this.classifyService.getListClassifyByPostID(2));
        
//        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
//        Orders od = new Orders();
//        CommentPost cm = new CommentPost();
//        session.save(od);

//        this.likePostService.addLikePost(this.userService.getUserByID(1).get(0), this.salePostService.getSalePostByID(2));
        return "test";
    }
    @Autowired
    private Cloudinary cloudinary;

    @PostMapping(value = "/test")
    public String test(@ModelAttribute(value = "userTest") @Valid User user,
            BindingResult result) {
        if (!result.hasErrors()) {
            try {
                Map upload = this.cloudinary.uploader().upload(user.getFileAvatar().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                System.out.println(upload.get("secure_url").toString());
                return "redirect:/";
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "test";
    }
}
