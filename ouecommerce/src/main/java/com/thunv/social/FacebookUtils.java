/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.social;

import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.thunv.pojo.User;
import com.thunv.service.AuthProviderService;
import com.thunv.service.UserService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author thu.nv2512
 */
@Component
@PropertySource("classpath:messages.properties")
public class FacebookUtils {
    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;
        @Autowired
    private AuthProviderService authProviderService;

    public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";

    public String getToken(final String code) throws ClientProtocolException, IOException {
        String link = String.format(FACEBOOK_LINK_GET_TOKEN, env.getProperty("facebook.appID").toString(),
                env.getProperty("facebook.appSecret").toString(), env.getProperty("facebook.redirectURL").toString(), code);
        String response = Request.Get(link).execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response).get("access_token");
        return node.textValue();
    }

    public com.restfb.types.User getUserInfo(final String accessToken) {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken,  env.getProperty("facebook.appSecret").toString(), Version.LATEST);
        return facebookClient.fetchObject("me", com.restfb.types.User.class, Parameter.with("fields", "email,name"));
    }

    public boolean createUser(com.restfb.types.User facebookInfo) {
        String username = facebookInfo.getName();
        Random rand = new Random();
        while (this.userService.checkExistUsername(username)) {
            username = username + rand.nextInt(100);
        }
        if (!this.userService.checkExistEmail(facebookInfo.getEmail())) {
            User user = new User();
            user.setAvatar(env.getProperty("facebook.defaultPic").toString());
            user.setPassword(env.getProperty("auth.secretKey").toString());
            user.setUsername(username);
            user.setAuthProvider(this.authProviderService.getAuthProviderByID(3));
            user.setEmail(facebookInfo.getEmail());
            try {
                this.userService.addUser(user);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public UserDetails buildUser(User u) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(u.getRole().getName()));
        UserDetails userDetail = new org.springframework.security.core.userdetails.User(u.getUsername(),env.getProperty("auth.secretKey").toString(), authorities);
        return userDetail;
    }
}
