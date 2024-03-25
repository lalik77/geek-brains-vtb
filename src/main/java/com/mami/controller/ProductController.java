package com.mami.controller;


import com.mami.entity.Product;
import com.mami.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductsList(Model model, @RequestParam(value = "word", required = false) String word) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProductsWithFilter(word));
        model.addAttribute("product", product);
        model.addAttribute("word", word);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product") Product product) {

        if (product.getId() == null || product.getTitle() == null || product.getTitle().isEmpty()) {

            return "redirect:/products";

        }

        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/add-product")
    public String showAddProduct(@ModelAttribute("product") Product product) {
        return "add-product";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {

        Product product = productService.getById(id);
        productService.remove(product);

        return "redirect:/products";
    }
}
