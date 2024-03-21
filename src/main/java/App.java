import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CartImpl;
import service.OrderService;
import service.ProductService;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService =
                (ProductService) annotationConfigApplicationContext.getBean("productService");

        //productService.printAll();
        //System.out.println(productService.findByTitle("bosh"));

        CartImpl cart = (CartImpl) annotationConfigApplicationContext.getBean("cart");
        cart.add(productService.findByTitle("bosh"));
        cart.add(productService.findByTitle("iphone"));

        //System.out.println(cart);

        OrderService orderService = (OrderService) annotationConfigApplicationContext.getBean("orderService");
        orderService.order();

    }
}
