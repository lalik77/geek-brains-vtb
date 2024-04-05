package com.mami.controller;

import com.mami.model.Item;
import com.mami.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String showItemsPage(Model model, @RequestParam(defaultValue = "0") int page) {

        Page<Item> itemsPage = itemService.getItemsPage(page);
        model.addAttribute("items",itemsPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",itemsPage.getTotalPages());
        return "items";
    }
}
