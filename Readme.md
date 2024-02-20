

# 9 - Reflection API. JDBC.Основы PostgreSQL

### 1 - Вторая часть урока, готовим окружение  
В pom.xml добавляем зависимость как в уроке 

![](img/pom-sqlite-jdbc.png)

Создаем папку db

![](img/folder-db.png)

В IDEA ultimate edition создаем datasource SQLite

![](img/sqlite.png)

![](img/main-db-1.png)
Проверяем в IDEA connection
![](img/main-db-2-idea-connected.png)

Пишем методы `connect()` и `dicconnect()` 

```java
public class MainApp {

  private static Connection connection;
  private static Statement statement;

  public static void connect() throws SQLException {
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:db/main.db");
      statement = connection.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
      throw new SQLException("Unable to connect");
    }
  }

  public static void disconnect() {
    try {
      statement.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public static void main(String[] args) {

    try {
      connect();

;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      disconnect();
    }

  }
}
```
На этом этапе все подключается и в блоке finally все отключается. 

Создаем таблицу 

![](img/create-students-sql.png)

Таблица создана без данных.

![](img/main-db-3-idea-connected-.png)

### 2 - Домашнее задание

![](img/HW-9.png)

#### 1 - Первая часть
Возможность разметки класса с помощью набора наших аннотаций

@Table
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String title();
}
```

@Column
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
}

```

Класс `Processor` - Обработчик, который будет анализировать класс и формировать в базе запрос. 
Делаем connect() и disconnect().
Создаем метод `void buildTable(Class clazz)`

```java
public static void buildTable(Class clazz) throws SQLException {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("Annotation @Table missed");
        }

        Table tableAnnotation = (Table) clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.title();
        Map<Class, String> map = new HashMap<>();
        map.put(int.class, "INTEGER");
        map.put(String.class, "TEXT");
        //  мы хотим получить SQL запрос в таком виде
        //`CREATE TABLE person (id INTEGER, name TEXT, age INTEGER);`

        //`CREATE TABLE IF NOT EXISTS`
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");

        //`CREATE TABLE IF NOT EXISTS person (`
        stringBuilder.append(tableName).append(" (");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                stringBuilder.append(field.getName())
                        .append(" ")
                        .append(map.get(field.getType()))
                        .append(", ");
            }
        }

        // `CREATE TABLE IF NOT EXISTS person (id INTEGER, name TEXT, age INTEGER ,`
        // отпиливаем два символа
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(");");
        // `CREATE TABLE IF NOT EXISTS person (id INTEGER, name TEXT, age INTEGER);`
        statement.executeUpdate(stringBuilder.toString());


    }
```

Ну и создаем точку входа и вызываем метод куда передаем `Person`

![](img/main-build-table.png)

Проверяем в db 

![](img/main-db-4-idea-connected.png)

#### 2 - Вторая часть

Второй обработчик аннотаций который должен добавлять объект размеченного класса в полученную таблицу.

Создаем еще один метод `void insertRecord(Object obj)`

```java
public static void insertRecord(Object obj) throws SQLException {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("Annotation @Table missed");
        }

        Table tableAnnotation = clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.title();

        StringBuilder columnsBuilder = new StringBuilder();
        StringBuilder valuesBuilder = new StringBuilder();


        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                columnsBuilder
                        .append(field.getName())
                        .append(", ");
                valuesBuilder.append("?, ");
            }
        }

        // Remove the trailing comma and space
        columnsBuilder.setLength(columnsBuilder.length() - 2);
        valuesBuilder.setLength(valuesBuilder.length() - 2);
        
        //`INSERT INTO person ( id ) VALUES (1)`
        String sql = "INSERT INTO " + tableName + " (" + columnsBuilder.toString()
                + ") VALUES (" + valuesBuilder.toString() + ")";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:db/main.db");
                PreparedStatement statement = connection.prepareStatement(sql)

        ) {
            int index = 1;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    statement.setObject(index++, value);
                }
            }
            statement.executeUpdate();

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field vales", e);
        }

    }
```

Комментируем первую часть задачи, так как таблица уже создана.
В main создаем объект класса `Person` и передаем его нашему методу
```java
  public static void main(String[] args) {

        // Первая задача
       /* try {
            connect();
            buildTable(Person.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }*/

        // Вторая задача
        Person person = new Person(1,"ALex",43);
        try {
            insertRecord(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```

Проверяем запись в БД

![](img/main-db-5-idea-connected.png)