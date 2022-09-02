/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thunv.pojo.Agency;
import com.thunv.subentity.Cart;
import com.thunv.pojo.Classify;
import com.thunv.pojo.CommentPost;
import com.thunv.pojo.Item;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.OrderState;
import com.thunv.pojo.Orders;
import com.thunv.pojo.PicturePost;
import com.thunv.pojo.Role;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.service.AgencyService;
import com.thunv.service.ClassifyService;
import com.thunv.service.CommentService;
import com.thunv.service.ItemService;
import com.thunv.service.LikePostService;
import com.thunv.service.MailService;
import com.thunv.service.OrderDetailService;
import com.thunv.service.OrderService;
import com.thunv.service.OrderStateService;
import com.thunv.service.PicturePostService;
import com.thunv.service.SalePostService;
import com.thunv.service.UserService;
import com.thunv.utils.Utils;
import com.thunv.validator.CommonItemValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    private AgencyService agencyService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MailService mailService;
    @Autowired
    private LikePostService likePostService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderStateService orderStateService;
    @Autowired
    private CommonItemValidator itemValidator;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private PicturePostService picturePostService;
    @Autowired
    private OrderDetailService orderDetailsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
            if (this.itemValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(this.itemValidator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    @PostMapping(value = "/add-comment/{productID}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<CommentPost> createComment(Model model, @RequestBody Map<String, String> params,
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
                        return new ResponseEntity<>(cmt, HttpStatus.CREATED);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/get-average-star/{productID}")
    public ResponseEntity<Map<String, Double>> getAverageStar(Model model,
            @PathVariable(value = "productID") String productID) {
        double starAvg = this.salePostService.getAverageStarRateByID(Integer.parseInt(productID));
        int star = (int) Math.round((double) (starAvg - 0.5));
        int nonStar = 5 - (int) Math.round((double) (starAvg + 0.49999999));
        int haftStar = 5 - (nonStar + star);
        Map<String, Double> result = new HashMap<>();
        result.put("starAvg", starAvg);
        result.put("star", star * 1.0);
        result.put("nonStar", nonStar * 1.0);
        result.put("haftStar", haftStar * 1.0);
        result.put("review", this.commentService.countCommentByPostID(Integer.parseInt(productID)) * 1.0);
        return new ResponseEntity<>(result, HttpStatus.OK);
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
    public ResponseEntity<Integer> countItemsQuantity(HttpSession session, @PathVariable(value = "itemID") String itemID) {
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
    public ResponseEntity<Double> getTotalPrice(HttpSession session, @PathVariable(value = "itemID") String itemID) {
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
            @RequestBody Map<String, Integer> params) {
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

                this.mailService.sendMail(mailTo, subject, title, content, this.utils.getItemToSendMail(cart), mailTemplate);

                session.removeAttribute("cart");
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @PostMapping(value = "/add-to-wishlist")
    public ResponseEntity<Integer> addToWishList(@RequestBody Map<String, Integer> params) {
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
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/publish-salepost/{postID}")
    public HttpStatus publishSalePost(@PathVariable(value = "postID") String postID) {
        SalePost post = this.salePostService.getSalePostByID(Integer.parseInt(postID));
        if (post.getItemSet().size() > 0) {
            if (this.salePostService.publishSalePost(post) == true) {
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/unpublish-salepost/{postID}")
    public HttpStatus unpublishSalePost(@PathVariable(value = "postID") String postID) {
        SalePost post = this.salePostService.getSalePostByID(Integer.parseInt(postID));
        if (this.salePostService.publishSalePost(post) == true) {
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping(value = "/delete-salepost/{postID}")
    public HttpStatus deleteSalePost(@PathVariable(value = "postID") String postID) {
        SalePost post = this.salePostService.getSalePostByID(Integer.parseInt(postID));
        if (this.salePostService.deleteSalePost(post) == true) {
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/get-item/{itemID}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Item> getItem(Model model,
            @PathVariable(value = "itemID") String itemID) {
        Item item = this.itemService.getItemByID(Integer.parseInt(itemID)).get(0);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/list-order-detail/{orderID}")
    public ResponseEntity<List<OrderDetails>> getOrderDetail(Model model,
            @PathVariable(value = "orderID") String orderID) {
        List<OrderDetails> listResult = this.orderDetailsService.getListOrderDetailByOrderID(Integer.parseInt(orderID));
        if (listResult != null) {
            return new ResponseEntity<>(listResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/add-item/{postID}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> addItemForSalePost(@PathVariable(value = "postID") String postID,
            @RequestPart(value = "avatarFile", required = false) MultipartFile file,
            @RequestPart("item") @Valid Item item, BindingResult result) {
        Map<String, String> errorMessages = new HashMap<>();
        HttpStatus status = null;
        System.err.println(item);
        System.err.println(item.getName());
        if (result.hasErrors()) {
            errorMessages = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            status = HttpStatus.BAD_REQUEST;
        } else {
            try {
                SalePost s = new SalePost();
                s.setPostID(Integer.parseInt(postID));
                item.setPostID(s);
                if (file != null) {
                    Map upload = this.cloudinary.uploader().upload(file.getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    item.setAvatar(upload.get("secure_url").toString());
                }
                if (this.itemService.addItem(item) == true) {
                    status = HttpStatus.CREATED;
                } else {
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            } catch (Exception e) {
            }

        }
        return new ResponseEntity<>(errorMessages, status);
    }

    @PostMapping(value = "/update-item/{itemID}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> updateItemForSalePost(@PathVariable(value = "itemID") String itemID,
            @RequestPart(value = "avatarFileUpdate", required = false) MultipartFile file,
            @RequestPart("updateItem") @Valid Item item, BindingResult result) {
        Map<String, String> errorMessages = new HashMap<>();
        HttpStatus status = null;
        System.err.println(item.getName());
        if (result.hasErrors()) {
            errorMessages = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            status = HttpStatus.BAD_REQUEST;
        } else {
            try {
                Item currentItem = this.itemService.getItemByID(Integer.parseInt(itemID)).get(0);
                if (currentItem != null) {
                    if (file != null) {
                        Map upload = this.cloudinary.uploader().upload(file.getBytes(),
                                ObjectUtils.asMap("resource_type", "auto"));
                        currentItem.setAvatar(upload.get("secure_url").toString());
                    }
                    currentItem.setDescription(item.getDescription());
                    currentItem.setInventory(item.getInventory());
                    currentItem.setName(item.getName());
                    currentItem.setUnitPrice(item.getUnitPrice());
                    boolean b = this.itemService.updateItem(currentItem);
                    System.err.println(b);
                    if (b == true) {
                        status = HttpStatus.OK;
                    } else {
                        status = HttpStatus.INTERNAL_SERVER_ERROR;
                    }
                } else {
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return new ResponseEntity<>(errorMessages, status);
    }

    @PostMapping(value = "/add-picture-set/{postID}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus addPictureSet(@PathVariable(value = "postID") String postID,
            @RequestPart(value = "files", required = false) MultipartFile file[]) {
        if (file.length != 0) {
            try {
                SalePost s = new SalePost();
                s.setPostID(Integer.parseInt(postID));
                for (int i = 0; i < file.length; i++) {
                    Map upload = this.cloudinary.uploader().upload(file[i].getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    PicturePost pb = new PicturePost();
                    pb.setPostID(s);
                    pb.setImage(upload.get("secure_url").toString());
                    if (this.picturePostService.addPicturePost(pb) == false) {
                        return HttpStatus.BAD_REQUEST;
                    }
                }
                return HttpStatus.CREATED;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping(value = "/picture-salepost/{picID}")
    public HttpStatus deletePictureSalePost(@PathVariable(value = "picID") String picID) {
        PicturePost pb = this.picturePostService.getPicturePostsByID(Integer.parseInt(picID)).get(0);
        if (this.picturePostService.deletePicturePost(pb) == true) {
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping(value = "/item-salepost/{itemID}")
    public HttpStatus deleteItemSalePost(@PathVariable(value = "itemID") String itemID) {
        Item item = this.itemService.getItemByID(Integer.parseInt(itemID)).get(0);
        if (item.getPostID().getItemSet().size() == 1 && item.getPostID().getIsActive() == 1) {
            return HttpStatus.CONFLICT;
        } else {
            if (this.itemService.deleteItem(item) == true) {
                return HttpStatus.NO_CONTENT;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/agency/{agencyID}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Agency> getAgency(@PathVariable(value = "agencyID") String agencyID) {
        return new ResponseEntity<>(this.agencyService.getAgencyByID(Integer.parseInt(agencyID)).get(0), HttpStatus.OK);
    }

    @DeleteMapping(value = "/agency/{agencyID}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public HttpStatus deleteAgency(@PathVariable(value = "agencyID") String agencyID) {
        Agency agent = this.agencyService.getAgencyByID(Integer.parseInt(agencyID)).get(0);
        User manager = agent.getManager();
        if (agent.getIsCensored() == 0) {
            if (this.agencyService.deleteAgency(agent) == true) {
                String mailTo = agent.getManager().getEmail();
                String subject = "Censorship result announcement";
                String title = String.format("Dear %s,", manager.getUsername());
                String content = "Your request to open an agency has been denied. Please feedback us if you have any problem.";
                String mailTemplate = "register-agent";
                this.mailService.sendMail(mailTo, subject, title, content, "", mailTemplate);
                return HttpStatus.NO_CONTENT;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @PutMapping(value = "/agency/{agencyID}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public HttpStatus censorshipAgency(@PathVariable(value = "agencyID") String agencyID) {
        Agency agent = this.agencyService.getAgencyByID(Integer.parseInt(agencyID)).get(0);
        User manager = agent.getManager();
        if (agent.getIsCensored() == 0) {
            agent.setIsActive(1);
            agent.setIsCensored(1);
            Role role = new Role();
            role.setRoleID(4);
            manager.setRole(role);
            if (this.agencyService.updateAgency(agent) == true && this.userService.updateUser(manager) == true) {
                String mailTo = agent.getManager().getEmail();
                String subject = "Censorship result announcement";
                String title = String.format("Dear %s,", manager.getUsername());
                String content = "Your request has been approved, you have become agent manager.<br>You can manage your store from now on.<br><br>Best regards.";
                String mailTemplate = "register-agent";
                this.mailService.sendMail(mailTo, subject, title, content, "", mailTemplate);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/ban-agency/{agencyID}")
    public HttpStatus banAgency(@PathVariable(value = "agencyID") String agencyID) {
        Agency agent = this.agencyService.getAgencyByID(Integer.parseInt(agencyID)).get(0);
        User manager = agent.getManager();
        if (agent.getIsCensored() == 1) {
            agent.setIsActive(0);
            if (this.agencyService.updateAgency(agent) == true) {
//                String mailTo = agent.getManager().getEmail();
//                String subject = "Censorship result announcement";
//                String title = String.format("Dear %s,", manager.getUsername());
//                String content = "Your store has been banned, please contact us to resolve it";
//                String mailTemplate = "register-agent";
//                this.mailService.sendMail(mailTo, subject, title, content, "", mailTemplate);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/unban-agency/{agencyID}")
    public HttpStatus unbanAgency(@PathVariable(value = "agencyID") String agencyID) {
        Agency agent = this.agencyService.getAgencyByID(Integer.parseInt(agencyID)).get(0);
        User manager = agent.getManager();
        if (agent.getIsCensored() == 1) {
            agent.setIsActive(1);
            if (this.agencyService.updateAgency(agent) == true) {
//                String mailTo = agent.getManager().getEmail();
//                String subject = "Censorship result announcement";
//                String title = String.format("Dear %s,", manager.getUsername());
//                String content = "Your store has been banned, please contact us to resolve it";
//                String mailTemplate = "register-agent";
//                this.mailService.sendMail(mailTo, subject, title, content, "", mailTemplate);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/change-state-order/{orderID}/{stateID}")
    public HttpStatus changeStateOrder(@PathVariable(value = "orderID") String orderID,
            @PathVariable(value = "stateID") String stateID) {
        try {
            OrderState os = this.orderStateService.getOrderStateByID(Integer.parseInt(stateID)).get(0);
            Orders order = this.orderService.getOrderByID(Integer.parseInt(orderID)).get(0);
            if (os != null && order != null) {
                order.setOrderState(os);
                if (this.orderService.updateOrder(order) == true) {
                    return HttpStatus.OK;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping(value = "/order/{orderID}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public HttpStatus deleteOrder(@PathVariable(value = "orderID") String orderID) {
        Orders order = this.orderService.getOrderByID(Integer.parseInt(orderID)).get(0);
        User user = order.getUserID();
        List<OrderDetails> listOD = this.orderDetailsService.getListOrderDetailByOrderID(order.getOrderID());
        listOD.forEach(od -> {
            Item item = od.getItemID();
            int qty = item.getInventory() + od.getQuantity();
            item.setInventory(qty);
            this.itemService.updateItem(item);
        });
        if (this.orderService.deleteOrder(order) == true) {
//            String mailTo = user.getEmail();
//            String subject = "We have canceled your order";
//            String title = String.format("Dear %s,", user.getUsername());
//            String content = "We have canceled your order.<br>Contact us for more details.<br><br>Best regards.";
//            String mailTemplate = "register-agent";
//            this.mailService.sendMail(mailTo, subject, title, content, "", mailTemplate);
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
