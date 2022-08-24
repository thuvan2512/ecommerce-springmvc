/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.validator.salepost;

import com.thunv.pojo.SalePost;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author thu.nv2512
 */
public class CategoryValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return SalePost.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SalePost post = (SalePost) o;
        if (post.getCategoryID().getCategoryID() == 0) {
            errors.rejectValue("categoryID", "message.err.category.choose");
        }
    }
    
}
