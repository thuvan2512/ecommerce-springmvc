/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.pojo.Item;
import com.thunv.repository.ItemRepository;
import com.thunv.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<Item> getItemByID(int itemID) {
        return this.itemRepository.getItemByID(itemID);
    }

    @Override
    public List<Object[]> getTopSeller(int i) {
        return this.itemRepository.getTopSeller(i);
    }

    @Override
    public List<Item> getItemByPostID(int i) {
        return this.itemRepository.getItemByPostID(i);
    }

    @Override
    public int countSoldByAgentID(int i) {  
        return this.itemRepository.countSoldByAgentID(i);
    }

    @Override
    public List<Object[]> getTopSellerByAgencyID(int top, int agentID) {
        return this.itemRepository.getTopSellerByAgencyID(top, agentID);
    }

    @Override
    public boolean addItem(Item item) {
        item.setIsActive(1);
        item.setIsClassified(1);
        return this.itemRepository.addItem(item);
    }

    @Override
    public boolean deleteItem(Item item) {
        return this.itemRepository.deleteItem(item);
    }

    @Override
    public boolean updateItem(Item item) {
        return this.itemRepository.updateItem(item);
    }

    @Override
    public int countItem() {
        return this.itemRepository.countItem();
    }
    
}
