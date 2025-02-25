package mock;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter methods for age and salary
    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

public class Mock_Q1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Nilendra", 21, 43200.2),
                new Employee("Archna", 20, 21200.2),
                new Employee("Vikash", 23, 23200.3),
                new Employee("Sunita", 18, 33400.1),
                new Employee("Dinesh", 18, 53600.2)
        );

        // Sorting by age (ascending) and salary (descending)
        employees.sort(
                Comparator.comparing(Employee::getAge)
                        .thenComparing(Comparator.comparing(Employee::getSalary).reversed())
        );

        employees.forEach(System.out::println);
    }
}
