package config;


import model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.CartImpl;
import service.OrderService;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public ProductService productService(){
        ProductService productService = new ProductService();
        return productService;
    }

    @Bean
    public CartImpl cart(){
        List<Product> list = new ArrayList<>();
        return new CartImpl(list);
    }

    @Bean
    public OrderService orderService(){
        return new OrderService(cart());
    }

}
