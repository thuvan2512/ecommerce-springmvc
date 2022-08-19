/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.PaymentType;
import com.thunv.repository.PaymentTypeRepository;
import com.thunv.service.PaymentTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    @Override
    public List<PaymentType> getPaymentStateByID(int id) {
        return this.paymentTypeRepository.getPaymentStateByID(id);
    }
    
}
