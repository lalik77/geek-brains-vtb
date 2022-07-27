package lecture8.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {

  @Test
  void averageSalaryTest() {
    // Arrange
    Employee[] employees1 = {
        new Employee("Alex", 78, 1200),
        new Employee("Ivan", 98, 1200),
        new Employee("Petr", 34, 1200),
        new Employee("Achot", 56, 1200),
    };
    Employee[] employees2 = {
        new Employee("Mohamed", 23, 1200),
        new Employee("Jamal", 56, 1200),
        new Employee("Jamila", 34, 1200),
        new Employee("Alexandra", 32, 1200),
        new Employee("Sonia", 72, 1200)
    };
    // Act
    String result1 = Task3.process(3, employees1);
    String result2 = Task3.process(1, employees2);
    String result3 = Task3.process(20, employees2);
    // Assert
    Assertions.assertEquals("3 самых старших сотрудников зовут:\n"
        + "Ivan, Alex, Achot", result1);
    Assertions.assertEquals("1 самых старших сотрудников зовут:\n"
        + "Sonia", result2);
    Assertions.assertEquals("wrong argument", result3);
  }
}