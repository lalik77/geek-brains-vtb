package com.mami.controller;

import com.mami.model.Item;
import com.mami.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String showItemsPage(Model model) {

        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("items", allItems);

        return "items";
    }
}
