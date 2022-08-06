/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.utils;

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
}
