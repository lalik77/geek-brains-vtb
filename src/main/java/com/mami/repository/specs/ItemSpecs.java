package com.mami.repository.specs;

import com.mami.model.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecs {

    public static Specification<Item> titleContains(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Item> priceBetween(Double minPrice, Double maxPrice) {
        return (root,criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
    }
}
