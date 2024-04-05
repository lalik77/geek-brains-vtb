
# 15. Spring Data.

![HW-15.png](img/HW-15.png)

Пункт 1 

Так как неоткуда переносить работу, буду создавать
с самого начала.

1 - Начинаю с `pom.xml`

2 - По окружению [см ветку](https://github.com/lalik77/geek-brains-vtb/tree/11-lecture)

3 - C запущенным контейнером PostgreSQL, заходим в него чтобы создать новую схему для flyway

![docker-exec-it-psql.png](img%2Fdocker-exec-it-psql.png)

`The \dn command in psql is used to list all schemas in the current PostgreSQL database.`

![list-all-schemas-1.png](img%2Flist-all-schemas-1.png)

`Ceate new schema`

![list-all-schemas-2.png](img%2Flist-all-schemas-2.png)

4 - Пишем в application.properties 
![app-properties.png](img/app-properties.png)

5 - Пишем `sql`
![script-1.png](img/script-1.png)

```sql
CREATE TABLE items (
    id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title varchar(50)
);
```
Запускаем Spring Boot приложение и Flyway создал нам таблицу `items`

![spring-boot-run-flyway.png](img%2Fspring-boot-run-flyway.png)

![hw15-schema.png](img/hw15-schema.png)

Если я делаю изменения в файле .sql, то получаю ошибку;  

![script-2.png](img/script-2.png)

![error-flyway-1.png](img/error-flyway-1.png)

Чтобы отключить создание entity (DDL handling) Hibernate(_ом), 
в `application.properties` добавим 

![app-properties-2.png](img/app-properties-2.png)

6 - Пишем след скрипт для заполнения товарами
V2__insert.sql
Дальше напишем слои (Controller, Service и Repo)

Пункт 2

1 - Пишем еще один скрипт для заполнения товарами
V4__insert.sql

2 - Реализуем пагинацию

 - `Service` слой

![service-layer-pagination.png](img%2Fservice-layer-pagination.png)

 - `Controller` слой

![controller-layer-pagination.png](img%2Fcontroller-layer-pagination.png)

 -  `View`

![view-pagination.png](img%2Fview-pagination.png)



[![hw-15-2](img/thumb.png)](https://youtu.be/1EZzg6mqwRQ "hw-15-2")


[PDF - Методичка 15](Java-ВТБ-Методичка-15.pdf)