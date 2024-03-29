package com.mami.repository;

import com.mami.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findByTitle(String title);
    List<Item> findByPriceBetween(Double min , Double max);

}
