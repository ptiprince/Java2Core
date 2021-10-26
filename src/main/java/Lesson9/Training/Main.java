package Lesson9.Training;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Organization> organizations = Arrays.asList(
                new Organization(1, "Project1", Arrays.asList(
                        new Employee("John", "Johnson", 33, Employee.Position.ENGINEER, 2000),
                        new Employee("Peter", "Peterson", 30, Employee.Position.ENGINEER, 2200),
                        new Employee("Peter", "Parker", 38, Employee.Position.DEVELOPER, 3000),
                        new Employee("Tim", "Robbins", 50, Employee.Position.DIRECTOR, 5000))),
                new Organization(2, "Project2", Arrays.asList(
                        new Employee("John", "Wijk", 42, Employee.Position.ENGINEER, 2000),
                        new Employee("Jack", "Nicholson", 65, Employee.Position.MANAGER, 3500))),
                new Organization(3, "Project3", Arrays.asList(
                        new Employee("Suzan", "Sarandon", 43, Employee.Position.ENGINEER, 2500),
                        new Employee("Richard", "Geer", 60, Employee.Position.ENGINEER, 3000),
                        new Employee("Will", "Smith", 38, Employee.Position.DEVELOPER, 3300),
                        new Employee("Tom", "Hanks", 50, Employee.Position.DIRECTOR, 4500),
                        new Employee("Tim", "Robbins", 50, Employee.Position.DIRECTOR, 5000)))
        );

        //Return all the employees with their positions who work on Project with >2 employees.
        System.out.println(organizations.stream()
                .filter(o -> o.getEmployeeList().size() > 2)
                .map(o -> o.getEmployeeList())
                .flatMap(e -> e.stream())
                .map(e -> {
                    return "\n" + e.getFirstName() + " " + e.getLastName() + ": " + e.getPosition();
                })
                .distinct()
                .collect(Collectors.toList()));
        System.out.println();

        //Create map where Key is a Position and value is firstName & lastName
        System.out.println(organizations.stream()
                .map(e -> e.getEmployeeList())
                .flatMap(p -> p.stream())
                .distinct()
                .collect(Collectors.groupingBy(f -> f.getPosition())));
        System.out.println();

        //Create map where Key is a Position and value is average payCheck
        System.out.println(organizations.stream()
                .map(e -> e.getEmployeeList())
                .flatMap(p -> p.stream())
                .collect(Collectors.groupingBy(f -> f.getPosition(), Collectors.averagingDouble(f -> f.getPayCheck()))));
        System.out.println();

        //Calculate total payCheck; class Optional can check on NullPointerException
        Optional<Integer> payCheckResult;
        payCheckResult = organizations.stream()
                .map(e -> e.getEmployeeList())
                .flatMap(p -> p.stream())
                .map(e ->  e.getPayCheck())
                .distinct()
                .reduce(Integer::sum);
        Integer result = payCheckResult.orElse(null);
        System.out.println("Total Pay Check is " + result);

    }
}
