
# 13. Spring Core.
![HW-13.png](img%2FHW-13.png)

Для работы со `Spring Application Context` подключим :

```xml
 <!-- Spring Core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>```
```

```xml
 <!-- Spring Beans -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
    </dependency>


```

```xml
<!-- Spring Core IO -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
```

```xml
<!-- Spring Expression Language (SpEL) -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-expression</artifactId>
        <version>${spring.version}</version>
    </dependency>

```

1 - Создаем класс `Product`

2 - Создаем компонент `ProductService`
 Можно разными способами создавать компоненты в Spring. Я выбрал такой, создаю через класс `AppConfig`,
на который я повесил аннотацию `@Configuration`

Создаем бин 

```java
 @Bean
    public ProductService productService(){
        ProductService productService = new ProductService();
        return productService;
    }
```

В `Аpp` тестируем

```java
AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService =
                (ProductService) annotationConfigApplicationContext.getBean("productService");

        productService.printAll();
        System.out.println(productService.findByTitle("bosh"));
```


3 - Создаем компонент `Cart` 

Создаем бин
```java
 @Bean
    public CartImpl cart(){
        List<Product> list = new ArrayList<>();
        return new CartImpl(list);
    }
```
В `Аpp` тестируем

```java
CartImpl cart = (CartImpl) annotationConfigApplicationContext.getBean("cart");
cart.add(productService.findByTitle("bosh"));
cart.add(productService.findByTitle("iphone"));

System.out.println(cart);
```



4 - Создаем компонент `OrderService` позволяющий из корзины сформировать заказ

Создаем бин
```java
@Bean
public OrderService orderService(){
return new OrderService(cart());
}

```

В `Аpp` тестируем

```java
 OrderService orderService = (OrderService) annotationConfigApplicationContext.getBean("orderService");
        orderService.order();
```

[Методичка](Java-ВТБ-Методичка-13.pdf)