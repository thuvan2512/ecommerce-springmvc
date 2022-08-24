/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.validator.agency;

import com.thunv.pojo.Agency;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author thu.nv2512
 */
public class AgencyAvatarValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Agency.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Agency agency = (Agency) o;
        if (agency.getFileAvatar() == null || agency.getFileAvatar().isEmpty()) {
            errors.rejectValue("fileAvatar", "message.err.file.nonExist");
        }
    }

}
