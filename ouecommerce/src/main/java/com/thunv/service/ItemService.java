/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service;

import com.thunv.pojo.Item;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface ItemService {
    List<Item> getItemByID(int itemID);
    List<Object[]> getTopSeller(int top);
    List<Item> getItemByPostID(int postID);
    int countSoldByAgentID(int agentID);
    List<Object[]> getTopSellerByAgencyID(int top,int agenctID);
}
