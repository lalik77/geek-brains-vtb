package lecture8.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {

  @Test
  void averageSalaryTest() {

    // Arrange
    Employee[] employees1 = {
        new Employee("Alex",23,1200),
        new Employee("Ivan",33,1200),
        new Employee("Petr",34,1200),
        new Employee("Achot",56,1200),
    };

    Employee[] employees2 = {
        new Employee("Alex",23,3000),
        new Employee("Ivan",33,3000),
        new Employee("Petr",34,1500),
        new Employee("Achot",56,1500),
    };

    // Act
    double averageSalary1 = Task2.computeAverageSalary(employees1);
    double averageSalary2 = Task2.computeAverageSalary(employees2);

    // Assert
    Assertions.assertEquals(1200,averageSalary1);
    Assertions.assertEquals(2250,averageSalary2);

  }
}
