/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.formatters;

import com.thunv.pojo.SaleStatus;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author thu.nv2512
 */
public class SaleStatusFormatter implements Formatter<SaleStatus>{

    @Override
    public String print(SaleStatus t, Locale locale) {
        return String.valueOf(t.getStID());
    }

    @Override
    public SaleStatus parse(String id, Locale locale) throws ParseException {
        SaleStatus st = new SaleStatus();
        st.setStID(Integer.parseInt(id));
        return st;
    }
    
}
