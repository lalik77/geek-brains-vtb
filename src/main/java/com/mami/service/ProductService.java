package com.mami.service;

import com.mami.entity.Product;
import com.mami.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsWithFilter(String word) {

        List<Product> all = productRepository.findAll();
        if (word == null) return all;
        return all.stream()
                .filter(p -> p.getTitle().contains(word))
                .collect(Collectors.toList());
    }


    public void add(Product product) {
        productRepository.save(product);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void remove(Product product) {

        productRepository.remove(product);
    }
}
