/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.social;

import com.thunv.subentity.GoogleInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thunv.pojo.User;
import com.thunv.service.AuthProviderService;
import com.thunv.service.UserService;
import java.util.Random;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author thu.nv2512
 */
@Component
@PropertySource("classpath:messages.properties")
public class GoogleUtils {

    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthProviderService authProviderService;
    private static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    private static final String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    private static final String GOOGLE_GRANT_TYPE = "authorization_code";

    public String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", env.getProperty("google.clientID").toString())
                        .add("client_secret", env.getProperty("google.clientSecret").toString())
                        .add("redirect_uri", env.getProperty("google.redirectURL").toString()).add("code", code)
                        .add("grant_type", GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response).get("access_token");
        return node.textValue();
    }

    public GoogleInfo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        System.err.println(response);
        ObjectMapper mapper = new ObjectMapper();
        GoogleInfo googleInfo = mapper.readValue(response, GoogleInfo.class);
        System.out.println(googleInfo);
        return googleInfo;
    }

    public boolean createUser(GoogleInfo googleInfo) {
        String username = googleInfo.getEmail().split("@")[0];
        Random rand = new Random();
        while (this.userService.checkExistUsername(username)) {
            username = username + rand.nextInt(100);
        }
        if (!this.userService.checkExistEmail(googleInfo.getEmail())) {
            User user = new User();
            user.setAvatar(googleInfo.getPicture());
            user.setPassword(env.getProperty("auth.secretKey").toString());
            user.setUsername(username);
            user.setAuthProvider(this.authProviderService.getAuthProviderByID(2));
            user.setEmail(googleInfo.getEmail());
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
