package service;

public class OrderService {

    private CartImpl cart;

    public OrderService(CartImpl cart) {
        this.cart = cart;
    }

    public void order() {
        System.out.println("Формирование заказа");
        System.out.println(cart.toString());
    }
}
