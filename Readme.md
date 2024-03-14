# 11 - Hibernate. Часть 1.

#### 1 - Готовим окружение

Смотреть [ветку](https://github.com/lalik77/geek-brains-vtb/tree/10-lecture)

Dashboard

![docker-dashboard.png](img%2Fdocker-dashboard.png)

docker exec -it ....

![docker-ps.png](img%2Fdocker-ps.png)

describe \d

![describe.png](img%2Fdescribe.png)

#### 2 - Домашнее задание

![HW-11.png](img%2FHW-11.png)

2.1 - Создадим таблицы покупатели - `customers` и товары `items`

```sql
CREATE TABLE customers
(
    id   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR NOT NULL
);
```

```sql
CREATE TABLE items
(
    id   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR UNIQUE NOT NULL,
    price DECIMAL(10,2) NOT NULL
);
```

2.2 - Условие задачи: у каждого покупателя свой набор купленный товаров, одна покупка одного товара - это отдельная
запись в таблице. Я понимаю так, создаем еще одну таблицу, покупатели_товары - `customers_items` или
`orders`

![uml.png](img%2Fuml.png)

```sql
CREATE TABLE orders
(
    order_id          INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    customer_id INTEGER,
    item_id     INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customers (id),
    FOREIGN KEY (item_id) REFERENCES items (id)
);
```

2.3 - Написать тестовое консольное приложение

- Начнем с подключения Hibernate и драйвера `postgresql` в `pom.xml`

![pom.xml.png](img%2Fpom.xml.png)

- Как в уроке создаем файл настроек hibernate.cfg.xml

![hibrnate-cfg.png](img%2Fhibrnate-cfg.png)

- Создадим класс `Main` для теста и новый пакет `model`, внутри пакета создаем две сущности
`Customer` и `Item`

```java
public class Main {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory()) {

            Session currentSession = sessionFactory.getCurrentSession();
            Customer customer1 = new Customer("Alex");
            currentSession.beginTransaction();
            currentSession.save(customer1);
            currentSession.getTransaction().commit();
        }
    }
}
```

Запускаем 
![hibernate-log.png](img%2Fhibernate-log.png)

В терминале проверяем 

![select-all-customers-terminal.png](img%2Fselect-all-customers-terminal.png)

- Заполняем таблицы, я заполнял через Hibernate эти две таблицы
- Позже создал скрипты, можно их найти в `resources`. Никакого каскадирования в скриптах я 
не писал, буду писать в коде с помощью `Hibernate` 

![customers-terminal.png](img%2Fcustomers-terminal.png)
![items-terminal.png](img%2Fitems-terminal.png)

```sql
INSERT INTO orders (customer_id, item_id) VALUES (1,2);
INSERT INTO orders (customer_id, item_id) VALUES (2,1);
INSERT INTO orders (customer_id, item_id) VALUES (3,1);
INSERT INTO orders (customer_id, item_id) VALUES (1,4);
INSERT INTO orders (customer_id, item_id) VALUES (3,2);
```
![orders.png](img%2Forders.png)

- Начинаем выставлять `ManyToMany ` отношения. 

![customer.png](img%2Fcustomer.png)
![items.png](img%2Fitems.png)

На этом коммите(finish until removePerson, have to add cascade.) в текущей ветке 
у нас сделано ДЗ до `/removePerson` и работает неправильно.

![hibernate-exception-1.png](img%2Fhibernate-exception-1.png)
Надо поиграть с каскадированием
Заглянем на диаграмму и на таблицу `orders` 
![uml-2.png](img%2Fuml-2.png)

![describe-orders.png](img%2Fdescribe-orders.png)

```sql
-- First, drop the existing foreign key constraint
ALTER TABLE orders
DROP CONSTRAINT orders_customer_id_fkey;

-- Recreate the foreign key constraint with ON DELETE SET NULL option
ALTER TABLE orders
ADD CONSTRAINT orders_customer_id_fkey
FOREIGN KEY (customer_id)
REFERENCES customers(id)
ON DELETE SET NULL;
```

```sql
-- First, drop the existing foreign key constraint
ALTER TABLE orders
    DROP CONSTRAINT orders_item_id_fkey;

-- Recreate the foreign key constraint with ON DELETE SET NULL option
ALTER TABLE orders
    ADD CONSTRAINT orders_item_id_fkey
        FOREIGN KEY (item_id)
            REFERENCES items(id)
            ON DELETE SET NULL;
```

Перепишем скрипт `create-table-orders.sql` в файл `create-table-orders-v2.sql`

- На коммите(implement /removePerson, /removeProduct) в текущей ветке, имплементирован механизм где мы имеем консольное приложение, которые принимает
на вход команды `/showProductsByPerson`, `/findPersonsByProductTitle`, `/removePerson` и `/removeProduct`.

[![Presentation 1](img/thumb-1.png)](https://youtu.be/aEoC_QchBME "Presentation 1")

- На коммите(implement /buy имя_покупателя название_товара) в текущей ветке, 
имплементирован фунционал `/buy имя_покупателя название_товара` 
