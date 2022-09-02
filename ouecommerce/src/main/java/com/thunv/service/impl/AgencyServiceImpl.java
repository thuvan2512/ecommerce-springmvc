/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import com.thunv.repository.AgencyRepository;
import com.thunv.service.AgencyService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class AgencyServiceImpl implements AgencyService{
    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public boolean registerAgency(Agency agency) {
        agency.setCreatedDate(new Date());
        agency.setIsCensored(0);
        return this.agencyRepository.registerAgency(agency);
    }

    @Override
    public boolean checkUserManager(User user) {
        return this.agencyRepository.checkUserManager(user);
    }

    @Override
    public List<Agency> getAgencyByUserID(int i) {
        return this.agencyRepository.getAgencyByUserID(i);
    }

    @Override
    public boolean updateAgency(Agency agency) {
        return this.agencyRepository.updateAgency(agency);
    }

    @Override
    public List<Agency> getListAgencyNeedCensorship() {
        return this.agencyRepository.getListAgencyNeedCensorship();
    }

    @Override
    public List<Agency> getAgencyByID(int agencyID) {
        return this.agencyRepository.getAgencyByID(agencyID);
    }

    @Override
    public boolean deleteAgency(Agency agency) {
        return this.agencyRepository.deleteAgency(agency);
    }

    @Override
    public List<Agency> getListAgencyByActive(int active) {
        return this.agencyRepository.getListAgencyByActive(active);
    }

    @Override
    public int countAgency() {
        return this.agencyRepository.countAgency();
    }

    @Override
    public List<Object[]> getTopAgency(int top) {
        return this.agencyRepository.getTopAgency(top);
    }

    @Override
    public List<Object[]> getStatsSaleFrequency(int top,int year, int quarter) {
        return this.agencyRepository.getStatsSaleFrequency(top,year, quarter);
    }
    
}
