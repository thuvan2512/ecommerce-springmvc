/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.utils;

import com.thunv.subentity.Cart;
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

    public double getTotalPriceCart(Map<Integer, Cart> cart) {
        int total = 0;
        if (cart != null) {
            for (Cart c : cart.values()) {
                total += c.getTotal();
            }
        }
        return total;
    }
    
    public String getItemToSendMail(Map<Integer, Cart> cart) {
        String content = "";
        for (Cart c: cart.values()) {
            content += "<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n" +
                "                            <td valign=\"middle\" width=\"80%\" style=\"text-align:left; padding: 0 2.5em;\">\n" +
                "                                <div class=\"product-entry\">\n" +
                String.format("<img src=\"%s\" alt=\"\" style=\"width: 100px; max-width: 600px; height: auto; margin-bottom: 20px; display: block;\">\n", c.getPicture()) +
                "                                    <div class=\"text\">\n" +
                String.format("<h4>%s</h4>\n", c.getName()) +
                String.format("<span>%s</span>\n", c.getDescription()) +
                String.format("<span>Qty:%d</span><br>\n", c.getQuantity()) +
                String.format("<span>Unit price: %,.0f VND</span>\n", c.getUnitPrice()) +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </td>\n" +
                "                            <td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n" +
                String.format("<span class=\"price\" style=\"color: #000; font-size: 20px;\">%,.0f VND</span>\n", c.getTotal()) +
                "                            </td>\n" +
                "                        </tr>";
        }
        content += "    <tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n" +
"                            <td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n" +
String.format("<span class=\"price\" style=\"color: #000; font-size: 20px;\">Total: %,.0f VND</span>\n", this.getTotalPriceCart(cart)) +
"                            </td>\n" +
"                        </tr>";
        return content;
    }
}
