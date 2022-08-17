/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.utils;

import com.thunv.pojo.Cart;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author thu.nv2512
 */
@Component
public class Utils {

    public String removePageParams(String params) {
        String result = params;
        if (params.split("&").length >= 2) {
            if (params.contains("page")) {
                result = params.split("&", 2)[1];
            }
        }
        return result;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf;
    }

    public int countCart(Map<Integer, Cart> cart) {
        int count = 0;
        if (cart != null) {
            for (Cart c : cart.values()) {
                count += c.getQuantity();
            }
        }
        return count;
    }

    public int getTotalPriceCart(Map<Integer, Cart> cart) {
        int total = 0;
        if (cart != null) {
            for (Cart c : cart.values()) {
                total += c.getTotal();
            }
        }
        return total;
    }
}
