# 12. Hibernate. Часть 2.

![HW-12.png](img%2FHW-12.png)

Касаемо окружения, смотреть [ветку ](https://github.com/lalik77/geek-brains-vtb/tree/11-lecture)

1 - Создание таблицы items и пополнение

```sql
CREATE TABLE items (
    id int GENERATED ALWAYS AS IDENTITY ,
    val int
);
```

```sql
DO $$
    DECLARE
        counter INTEGER := 1;
    BEGIN
        WHILE counter <= 40 LOOP
                INSERT INTO items (val) VALUES (0);
                counter := counter + 1;
            END LOOP;
    END $$;
```

2 - В файле `hibernate.cfg.xml`  поставить 8 так как запускать будем 8 потоков.

![hibernate-cfg-xml.png](img%2Fhibernate-cfg-xml.png)


3.1 - Optimistic
![optimistic.png](img%2Foptimistic.png)

3.2 - Pessimistic 
С pessimistic, что-то не так

![pessimistic.png](img%2Fpessimistic.png)
Во время выполнения получаю много `Deadlock`
![dead-lock.png](img%2Fdead-lock.png)

В `catch`, блоке добавлю `rollBack()` и проверю заново.
![app-pessimistic.png](img%2Fapp-pessimistic.png)
