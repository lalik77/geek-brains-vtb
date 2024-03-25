# 14. Spring Boot. Thymeleaf.Spring Security.

"Имеющий код" - это тот код с `Product` в конце лекции.
Я буду писать все с самого начала. 

![HW-14.png](img/HW-14.png)

1 - Настраиваю проект
Так, чтобы он был `Spring Boot` проектом и в `pom.xml` добавляю все мне 
необходимые зависимости

2 - Создаю класc `Product` и слои ( контроллер, сервис, репо )

3 - В папке `resources` создаю папку `templates`, где будут  `.html` файлы.

Приступаю к ДЗ (Обычный вариант - учитываю что добавление товара реализовано)

1 - Добавляю возможность редактировать название и цену товаров
 В контроллере добавляем два метода 

![controller-edit.png](img%2Fcontroller-edit.png)

 В сервисе добавляем еще один метод

![service-update.png](img%2Fservice-update.png)

 В репозитории симулируем работу в БД 

![repo-update.png](img%2Frepo-update.png)

2 - Фильтр
 
 - В  `products.html` добавляю форму над таблицей
![filtr-products-html.png](img%2Ffiltr-products-html.png)

 - В контроллере меняем метод `showProductsList`

![controller-show-product-list.png](img%2Fcontroller-show-product-list.png)
 
3 - Добавлю удаление

 - В  `products.html` добавляю кнопку удаления

![products-html-delete.png](img%2Fproducts-html-delete.png)

В итоге имеем 

[![hw-14](img/thumb.png)](https://youtu.be/v5WRlbyS_3g "hw-14")

[PDF - Методичка 14](Java-ВТБ-Методичка-14.pdf)