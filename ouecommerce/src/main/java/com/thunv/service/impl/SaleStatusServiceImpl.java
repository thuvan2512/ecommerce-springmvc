/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.SaleStatus;
import com.thunv.repository.SaleStatusRepository;
import com.thunv.service.SaleStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class SaleStatusServiceImpl implements SaleStatusService{
    @Autowired
    private SaleStatusRepository saleStatusRepository;
    @Override
    public List<SaleStatus> getListSaleStatus() {
        return this.saleStatusRepository.getListSaleStatus();
    }
    
}
