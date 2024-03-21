package service;

import model.Product;

import java.util.List;

public class CartImpl implements CartShopService {

    private final List<Product> list;

    public CartImpl(List<Product> list) {
        this.list = list;
    }

    public void add(Product product) {
        list.add(product);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "list=" + list +
                '}';
    }
}
