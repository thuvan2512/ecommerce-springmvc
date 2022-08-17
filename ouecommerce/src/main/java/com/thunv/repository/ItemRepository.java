/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.repository;

import com.thunv.pojo.Item;
import java.util.List;

/**
 *
 * @author thu.nv2512
 */
public interface ItemRepository {
    List<Item> getItemByID(int itemID);
    List<Object[]> getTopSeller(int top);
    List<Item> getItemByPostID(int postID);
}
