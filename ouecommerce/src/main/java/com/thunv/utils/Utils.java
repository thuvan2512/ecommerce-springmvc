/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.utils;

import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.Orders;
import com.thunv.subentity.Cart;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections.MapUtils;
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

    public Map<Integer, List<OrderDetails>> groupOrderByOrderID(List<OrderDetails> listOrderDetail) {
        Map<Integer, List<OrderDetails>> mapResult
                = listOrderDetail.stream().collect(Collectors.groupingBy(od -> od.getOrderID().getOrderID()));
        mapResult = mapResult.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return mapResult;
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

    public List<Object[]> customListStatsMonth(List<Object[]> list) {
        boolean flag = false;
        if (list != null) {
            for (int i = 1; i <= 12; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == (int) list.get(j)[0]) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    Object[] term = {i, 0};
                    list.add(term);
                }
                flag = false;
            }
            Collections.sort(list, (Object[] a1, Object[] a2) -> (int) a1[0] - (int) a2[0]);
        }
        return list;
    }

    public List<Object[]> customListStatsQuarter(List<Object[]> list) {
        boolean flag = false;
        if (list != null) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == (int) list.get(j)[0]) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    Object[] term = {i, 0};
                    list.add(term);
                }
                flag = false;
            }
            Collections.sort(list, (Object[] a1, Object[] a2) -> (int) a1[0] - (int) a2[0]);
        }
        return list;
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
        for (Cart c : cart.values()) {
            content += "<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n"
                    + "                            <td valign=\"middle\" width=\"80%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                    + "                                <div class=\"product-entry\">\n"
                    + String.format("<img src=\"%s\" alt=\"\" style=\"width: 100px; max-width: 600px; height: auto; margin-bottom: 20px; display: block;\">\n", c.getPicture())
                    + "                                    <div class=\"text\">\n"
                    + String.format("<h4>%s</h4>\n", c.getName())
                    + String.format("<span>%s</span>\n", c.getDescription())
                    + String.format("<span>Qty:%d</span><br>\n", c.getQuantity())
                    + String.format("<span>Unit price: %,.0f VND</span>\n", c.getUnitPrice())
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </td>\n"
                    + "                            <td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                    + String.format("<span class=\"price\" style=\"color: #000; font-size: 20px;\">%,.0f VND</span>\n", c.getTotal())
                    + "                            </td>\n"
                    + "                        </tr>";
        }
        content += "    <tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n"
                + "                            <td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                + String.format("<span class=\"price\" style=\"color: #000; font-size: 20px;\">Total: %,.0f VND</span>\n", this.getTotalPriceCart(cart))
                + "                            </td>\n"
                + "                        </tr>";
        return content;
    }
}
