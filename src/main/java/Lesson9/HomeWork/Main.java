package Lesson9.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Peter", Arrays.asList(new Course("GIT"), new Course("Java2Core"),
                new Course("AutomationTesting"))));
        students.add(new Student("George", Arrays.asList(new Course("Java1"), new Course("HTML/CSS"),
                new Course("Java2Core"), new Course("Java3"))));
        students.add(new Student("Christine", Arrays.asList(new Course("GIT"), new Course("Java1"),
                new Course("Java2Core"), new Course("Java3"), new Course("DataBases"))));
        students.add(new Student("Alex", Arrays.asList( new Course("Java1"), new Course("Java2Core"))));
        students.add(new Student("Paul", Arrays.asList( new Course("Java3"), new Course("DataBases"))));

        //Create Function which takes Student list as input and the list of unique Courses as output
        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));
        System.out.println();

        //Create Function which takes Student list as input and the list of 3 most curious Students as output
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));
        System.out.println();

        //Create Function which takes Student list and instance of class Courses as input and
        // the list of Students taking this Course as output
        Course course = new Course("Java2Core");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .map(e -> {
                    return course + " " + e.getName();
                })
                .collect(Collectors.toList()));
    }
}
