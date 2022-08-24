/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.formatters;

import com.thunv.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import org.springframework.format.Formatter;

/**
 *
 * @author thu.nv2512
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category t, Locale locale) {
        return String.valueOf(t.getCategoryID());
    }

    @Override
    public Category parse(String cateID, Locale locale) throws ParseException {
        Category c = new Category();
        c.setCategoryID(Integer.parseInt(cateID));
        return c;
    }
    
}
