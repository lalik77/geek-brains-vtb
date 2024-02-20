package lecture9.homework;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Processor {

    private static Connection connection;
    private static Statement statement;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:db/main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void buildTable(Class<Person> clazz) throws SQLException {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("Annotation @Table missed");
        }

        Table tableAnnotation = clazz.getAnnotation(Table.class);
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
}
