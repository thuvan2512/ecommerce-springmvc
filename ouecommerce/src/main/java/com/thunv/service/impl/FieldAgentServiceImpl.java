/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.AgentField;
import com.thunv.repository.FieldAgentRepository;
import com.thunv.service.FieldAgentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class FieldAgentServiceImpl implements FieldAgentService{
    @Autowired
    private FieldAgentRepository fieldAgentRepository;

    @Override
    public List<AgentField> getListAgentFields() {
        return this.fieldAgentRepository.getListAgentFields();
    }
    
}
