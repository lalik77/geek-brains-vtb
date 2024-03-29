package com.mami.service;


import com.mami.model.Item;
import com.mami.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        //System.out.println(itemRepository.findByTitle("Tree"));
        //System.out.println(itemRepository.findByPriceBetween(30.0,70.0));
        return itemRepository.findAll();
    }

}
