package lecture8.homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

  public static String process(int i, Employee[] employees) {

    String result = "wrong argument";

    if (i >= employees.length) {
      return result;
    }

    final List<Employee> list = Arrays.stream(employees)
        .sorted(((o1, o2) -> o2.getAge() - o1.getAge()))
        .limit(i)
        .collect(Collectors.toList());

    final List<String> names = list.stream()
        .map(Employee::getName)
        .collect(Collectors.toList());

    String formattedNames = Arrays.toString(names.toArray())
        .replace("[", "").replace("]", "");

    result = i + " самых старших сотрудников зовут:\n"
        + formattedNames;

    return result;
  }
}
