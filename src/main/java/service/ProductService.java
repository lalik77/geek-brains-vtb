package service;

import model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductService {

    private List<Product> products;


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void printAll() {
        products.forEach(System.out::println);
    }

    public Product findByTitle(String title) {
        Optional<Product> productByTitle = products.stream()
                .filter(product -> product.getTitle().equalsIgnoreCase(title))
                .findFirst();

        return productByTitle.orElse(null);
    }


    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1,"iPhone",234.45));
        products.add(new Product(2,"Samsung",123.15));
        products.add(new Product(3,"MacBook Air",456.12));
        products.add(new Product(4,"MacBook Pro",670.96));
        products.add(new Product(5,"Samsung S21",123.00));
        products.add(new Product(6,"Velo Decathlon",312.23));
        products.add(new Product(7,"Ipad",245.34));
        products.add(new Product(8,"Bosh",112.34));
        products.add(new Product(9,"Worx",456.12));
        products.add(new Product(10,"Makita",232.00));
        System.out.println("Initialization method is called");
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "products=" + products +
                '}';
    }
}
