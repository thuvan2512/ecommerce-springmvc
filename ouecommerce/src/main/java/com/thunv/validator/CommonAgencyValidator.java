/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.validator;

import com.thunv.pojo.Agency;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author thu.nv2512
 */
public class CommonAgencyValidator implements Validator {

    @Autowired
    private javax.validation.Validator beanValidator;
    Set<Validator> springValidators;

    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }

    @Override
    public boolean supports(Class<?> type) {
        return Agency.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(o);
        for (ConstraintViolation<Object> obj : beans) {
            errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
        }
        for (Validator v : this.springValidators) {
            v.validate(o, errors);
        }
    }

}
