/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.thunv.subentity.Cart;
import com.thunv.pojo.Classify;
import com.thunv.pojo.CommentPost;
import com.thunv.pojo.Item;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.service.ClassifyService;
import com.thunv.service.CommentService;
import com.thunv.service.ItemService;
import com.thunv.service.LikePostService;
import com.thunv.service.MailService;
import com.thunv.service.OrderService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu.nv2512
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private SalePostService salePostService;
    @Autowired
    private ItemService ItemService;
    @Autowired
    private Utils utils;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MailService mailService;
    @Autowired
    private LikePostService likePostService;

    @GetMapping("/salepost/{salePostID}")
    public ResponseEntity<List<SalePost>> getSalePostByID(
            @PathVariable(value = "salePostID") String salePostID) {
        List<SalePost> listResults = new ArrayList<>();
        listResults.add(this.salePostService.getSalePostByID(Integer.parseInt(salePostID)));
        return new ResponseEntity<>(listResults, HttpStatus.OK);
    }

    @GetMapping("/cart/{itemID}/{quantity}")
    public ResponseEntity<Integer> addToCart(@PathVariable(value = "itemID") String itemID,
            @PathVariable(value = "quantity") String qty,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        Item item;
        try {
            item = this.ItemService.getItemByID(Integer.parseInt(itemID)).get(0);
        } catch (Exception e) {
            item = null;
        }
        if (item != null) {
            if (cart.containsKey(Integer.parseInt(itemID)) == true) {
                Cart c = cart.get(item.getItemID());
                int quantity = c.getQuantity() + Integer.parseInt(qty);
                if (quantity > item.getInventory()) {
                    quantity = item.getInventory();
                }
                c.setQuantity(quantity);
                c.setTotal(item.getUnitPrice() * quantity);
            } else {
                Cart c = new Cart();
                c.setItemID(item.getItemID());
                c.setName(item.getName());
                c.setUnitPrice(item.getUnitPrice());
                c.setPicture(item.getAvatar());
                int quantity = Integer.parseInt(qty);
                if (quantity > item.getInventory()) {
                    quantity = item.getInventory();
                }
                c.setQuantity(quantity);
                c.setTotal(item.getUnitPrice() * quantity);
                c.setDescription(item.getDescription());
                cart.put(item.getItemID(), c);
            }
//            System.err.println(this.utils.countCart(cart));
            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(this.utils.countCart(cart), HttpStatus.OK);
    }

    @PostMapping(value = "/add-comment/{productID}")
    public ResponseEntity<List<CommentPost>> createComment(Model model, @RequestBody Map<String, String> params,
            @PathVariable(value = "productID") String productID) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                if (username != null) {
                    User userComment = this.userService.getUserByUsername(username).get(0);
                    String content = params.get("content");
                    int star = Integer.parseInt(params.get("star"));
                    CommentPost cmt = new CommentPost();
                    if (content != null) {
                        cmt.setContent(content);
                    }
                    if (star != 0) {
                        cmt.setStarRate(star);
                    }
                    if (userComment != null) {
                        cmt.setUserID(userComment);
                    }
                    cmt.setPostID(this.salePostService.getSalePostByID(Integer.parseInt(productID)));
                    if (this.commentService.addComment(cmt)) {
                        List<CommentPost> results = new ArrayList<>();
                        results.add(cmt);
                        return new ResponseEntity<>(results, HttpStatus.CREATED);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/list-items/{salepostID}")
    public ResponseEntity<List<Item>> getListClassify(@PathVariable(value = "salepostID") String salepostID) {
        List<Item> listResults = null;
        try {
            listResults = this.ItemService.getItemByPostID(Integer.parseInt(salepostID));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(listResults, HttpStatus.OK);
    }

    @GetMapping(value = "/getQty/{itemID}")
    public ResponseEntity<Integer> getQuantityInStock(@PathVariable(value = "itemID") String itemID) {
        Item item = this.ItemService.getItemByID(Integer.parseInt(itemID)).get(0);
        int quantity = item.getInventory();
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getTotalQty")
    public ResponseEntity<Integer> getTotalQuantity(HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        int qty = this.utils.countCart(cart);
        return new ResponseEntity<>(qty, HttpStatus.OK);
    }
    
    @GetMapping(value = "/count-items")
    public ResponseEntity<Integer> countItems(HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        int qty = 0;
        if (cart != null) {
            qty = cart.values().size();
        }
        return new ResponseEntity<>(qty, HttpStatus.OK);
    }
    @GetMapping(value = "/count-items-quantity/{itemID}")
    public ResponseEntity<Integer> countItemsQuantity(HttpSession session,@PathVariable(value = "itemID") String itemID) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        int qty = 0;
        if (cart != null && cart.containsKey(Integer.parseInt(itemID))) {
            qty = cart.get(Integer.parseInt(itemID)).getQuantity();
        }
        return new ResponseEntity<>(qty, HttpStatus.OK);
    }
    @GetMapping(value = "/getTotalPrice")
    public ResponseEntity<Double> getTotalPrice(HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        double total = this.utils.getTotalPriceCart(cart);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
    @GetMapping(value = "/getTotalItem/{itemID}")
    public ResponseEntity<Double> getTotalPrice(HttpSession session,@PathVariable(value = "itemID") String itemID) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        double total = 0;
        if (cart != null && cart.containsKey(Integer.parseInt(itemID))) {
            total = cart.get(Integer.parseInt(itemID)).getTotal();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
    
    @PutMapping(value = "/update-cart/{itemID}/{quantity}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCart(@PathVariable(value = "itemID") String itemID,
            @PathVariable(value = "quantity") String qty,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        Item item;
        try {
            item = this.ItemService.getItemByID(Integer.parseInt(itemID)).get(0);
        } catch (Exception e) {
            item = null;
        }
        if (item != null && cart != null) {
            if (cart.containsKey(Integer.parseInt(itemID)) == true) {
                Cart c = cart.get(item.getItemID());
                int quantity = Integer.parseInt(qty);
                if (quantity > item.getInventory()) {
                    quantity = item.getInventory();
                }
                if (quantity <= 0) {
                    quantity = 1;
                }
                c.setQuantity(quantity);
                c.setTotal(item.getUnitPrice() * quantity);
            }
            session.setAttribute("cart", cart);
        }
    }

    @DeleteMapping(value = "/delete-cart/{itemID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable(value = "itemID") String itemID,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(Integer.parseInt(itemID))) {
            cart.remove(Integer.parseInt(itemID));
            session.setAttribute("cart", cart);
        }
    }
    
    @PostMapping(value = "/payment")
    public HttpStatus paymentProceed(HttpSession session,
            @RequestBody Map<String, Integer> params){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = null;
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        if (!this.userService.getUserByUsername(username).isEmpty()) {
            currentUser = this.userService.getUserByUsername(username).get(0);
            int paymentType = params.get("paymentType");
            Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
            if (this.orderService.addOrder(cart, currentUser, paymentType) == true) {
                String mailTo = currentUser.getEmail();
                String subject = "Thank you for shopping at OU ecommerce";
                String title = String.format("Dear %s,", currentUser.getUsername());
                String content = "We have received your order";
                String mailTemplate = "mail";
                
//                this.mailService.sendMail(mailTo, subject, title, content,this.utils.getItemToSendMail(cart), mailTemplate);  

                session.removeAttribute("cart");
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }
    @PostMapping(value = "/add-to-wishlist")
    public ResponseEntity<Integer> addToWishList(@RequestBody Map<String, Integer> params){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        if (username != "") {
            User currentUser = this.userService.getUserByUsername(username).get(0);
            int postID = params.get("postID");
            SalePost salePost = this.salePostService.getSalePostByID(postID);
            int result = this.likePostService.addLikePost(currentUser, salePost);
            if (result != -1) {
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(-1,HttpStatus.BAD_REQUEST);
    }
}
