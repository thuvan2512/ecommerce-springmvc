/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface AgencyRepository {
    boolean registerAgency(Agency agency);
    boolean checkUserManager(User user);
    List<Agency> getAgencyByUserID(int userID);
    List<Agency> getListAgencyNeedCensorship();
    List<Agency> getAgencyByID(int agencyID);
    List<Agency> getListAgencyByActive(int active);
    List<Object[]> getTopAgency(int top);
    List<Object[]> getStatsSaleFrequency(int top,int year, int quarter);
    boolean updateAgency(Agency agency);
    boolean deleteAgency(Agency agency);
    int countAgency();
}
