/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import com.thunv.service.AgencyService;
import com.thunv.service.AuthProviderService;
import com.thunv.service.FieldAgentService;
import com.thunv.service.UserService;
import com.thunv.validator.CommonAgencyValidator;
import com.thunv.validator.CommonUserValidator;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author thu.nv2512
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserService userService;
    @Autowired
    private CommonAgencyValidator agencyValidator;
    @Autowired
    private AgencyService agencyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
            if (this.agencyValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(this.agencyValidator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/wishlist")
    public String wishListPage() {
        return "wishlist";
    }

    @GetMapping(value = "/profile")
    public String profileViewPage(Model model) {
        model.addAttribute("user", new User());
        return "profile";
    }

    @PostMapping(value = "/profile")
    public String profilePage(@RequestParam CommonsMultipartFile fileAvatar,
            @RequestParam Map<String, String> params, Model model) {
//        this.cloudinary.uploader().upload(fileAvatar.getBytes(),
//                        ObjectUtils.asMap("resource_type", "auto"));
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        String error_ms = null;
        String ms = null;
        try {
            if (fileAvatar.isEmpty() == false) {
                Map upload = this.cloudinary.uploader().upload(fileAvatar.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                currentUser.setAvatar(upload.get("secure_url").toString());
            }
            String firstname = params.get("firstname");
            String lastname = params.get("lastname");
            String address = params.get("address");
            String password = params.get("password");
            String confirm = params.get("repassword");
            if (confirm != null && password != null) {
                if (confirm.isBlank() == false && password.isBlank() == false) {
                    if (confirm.equals(password) == false) {
                        error_ms = "Wrong password !!!";
                        model.addAttribute("error_ms", error_ms);
                        return "profile";
                    } else {
                        currentUser.setRePassword(password);
                    }
                }
                if (confirm.isBlank() == true && password.isBlank() == false
                        || confirm.isBlank() == false && password.isBlank() == true) {
                    error_ms = "Enter full password information !!!";
                    model.addAttribute("error_ms", error_ms);
                    return "profile";
                }
            }
            if (firstname.isBlank() == false) {
                currentUser.setFirstName(firstname);
            }
            if (lastname.isBlank() == false) {
                currentUser.setLastName(lastname);
            }
            if (address.isBlank() == false) {
                currentUser.setAddress(address);
            }
            if (this.userService.updateUser(currentUser) != true) {
                error_ms = "Update failed";
            } else {
                ms = "Update successful !!!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("ms", ms);
        model.addAttribute("error_ms", error_ms);
//        return "profile";
        return "redirect:/user/profile";
    }

    @GetMapping(value = "/register-agency")
    public String registerAgencyView(Model model) {
        model.addAttribute("agent", new Agency());
        return "register-agency";
    }

    @PostMapping(value = "/register-agency")
    public String registerAgency(Model model, @ModelAttribute(value = "agent") @Valid Agency agency,
            BindingResult result) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User currentUser = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            currentUser = this.userService.getUserByUsername(username).get(0);
        }
        if (!result.hasErrors()) {
            if (this.agencyService.checkUserManager(currentUser) == true) {
                try {
                    Map upload = this.cloudinary.uploader().upload(agency.getFileAvatar().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    System.out.println(upload.get("secure_url").toString());
                    agency.setAvatar(upload.get("secure_url").toString());
                    agency.setManager(currentUser);
                    if (this.agencyService.registerAgency(agency) == true) {
                        return "redirect:/";
                    }
                } catch (Exception ex) {
                    String err_ms;
                    err_ms = "Register failed !!!";
                    model.addAttribute("err_ms", err_ms);
                }
            } else {
                String err_ms;
                err_ms = "Previously registered account!!!";
                model.addAttribute("err_ms", err_ms);
            }
        }
        return "register-agency";
    }
}
