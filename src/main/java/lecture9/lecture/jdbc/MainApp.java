package lecture9.lecture.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

            // Insert
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ( 'Bob3','100' )");

            // Read
      /*try(ResultSet rs = statement.executeQuery("SELECT * FROM students;");) {
        while (rs.next()) {
          System.out.println(rs.getInt(1) + " "
              + rs.getString("name" ) + " " + rs.getString("score"));
        }
      }catch (SQLException sqlException) {
        sqlException.printStackTrace();
      }*/

            // Update
            /*statement.executeUpdate("UPDATE  students SET score = 80 WHERE id = 1");*/

            //Delete
            // statement.executeUpdate("DELETE FROM students WHERE id = 3;");
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }

    }
}
