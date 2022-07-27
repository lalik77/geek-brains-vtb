package lecture8.homework;

import java.util.Arrays;

public class Task2 {

  public static double computeAverageSalary(Employee[] employees) {

    return Arrays.stream(employees)
        .mapToDouble(Employee::getSalary)
        .average()
        .orElse(0);
  }

}

class Employee {

  private String name;
  private int age;
  private double salary;

  public Employee(String name, int age, int salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}