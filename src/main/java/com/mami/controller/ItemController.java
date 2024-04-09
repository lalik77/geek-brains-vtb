package com.mami.controller;

import com.mami.model.Item;
import com.mami.repository.specs.ItemSpecs;
import com.mami.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    // Пункт 2
   /* @GetMapping
    public String showItemsPage(Model model, @RequestParam(defaultValue = "0") int page) {

        Page<Item> itemsPage = itemService.getItemsPage(page);
        model.addAttribute("items",itemsPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",itemsPage.getTotalPages());
        return "items";
    }*/

    @GetMapping
    public String showItemsPage(Model model, @RequestParam(defaultValue = "0") int page,
                                @RequestParam(required = false) String title,
                                @RequestParam(required = false) Double minPrice,
                                @RequestParam(required = false) Double maxPrice) {

        Specification<Item> spec = Specification.where(null);
        if (title != null && !title.isEmpty()) {
            spec = spec.and(ItemSpecs.titleContains(title));
        }
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(ItemSpecs.priceBetween(minPrice, maxPrice));
        }

        Pageable pageable = PageRequest.of(page, 10); // 10 items per page
        Page<Item> itemsPage = itemService.getItemsPage(spec, pageable);

        model.addAttribute("items", itemsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemsPage.getTotalPages());

        // Add form values to retain them in the view
        model.addAttribute("title", title);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

        return "items";
    }
}
