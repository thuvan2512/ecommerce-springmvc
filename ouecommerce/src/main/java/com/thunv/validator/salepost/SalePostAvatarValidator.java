/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.validator.salepost;

import com.thunv.validator.agency.*;
import com.thunv.pojo.Agency;
import com.thunv.pojo.SalePost;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author thu.nv2512
 */
public class SalePostAvatarValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return SalePost.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SalePost post = (SalePost) o;
        if (post.getFileAvatar() == null || post.getFileAvatar().isEmpty()) {
            errors.rejectValue("fileAvatar", "message.err.file.nonExist");
        }
    }

}
