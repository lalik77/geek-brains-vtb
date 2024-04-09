package com.mami.service;


import com.mami.model.Item;
import com.mami.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Пункт 1
   /* public List<Item> getAllItems() {
        //System.out.println(itemRepository.findByTitle("Tree"));
        //System.out.println(itemRepository.findByPriceBetween(30.0,70.0));
        return itemRepository.findAll();
    }*/

    // 2 ой пункт дз
  /*  public Page<Item> getItemsPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,10);
        return itemRepository.findAll(pageable);
    }*/

    public Page<Item> getItemsPage(Specification<Item> spec, Pageable pageable) {
        return itemRepository.findAll(spec, pageable);
    }

}
