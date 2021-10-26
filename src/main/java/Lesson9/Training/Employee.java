package Lesson9.Training;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String LastName;
    private int age;
    private Position position;
    private int payCheck;

    enum Position {
        ENGINEER, DEVELOPER, MANAGER, DIRECTOR
    }

    public Employee(String firstName, String lastName, int age, Position position, int payCheck) {
        this.firstName = firstName;
        LastName = lastName;
        this.age = age;
        this.position = position;
        this.payCheck = payCheck;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPayCheck() {
        return payCheck;
    }

    public void setPayCheck(int payCheck) {
        this.payCheck = payCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && payCheck == employee.payCheck && Objects.equals(firstName, employee.firstName)
                && Objects.equals(LastName, employee.LastName) && position == employee.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName, age, position, payCheck);
    }

    @Override
    public String toString() {
        return "\nEmployee: " + firstName + " " + LastName + ", age: " + age +
                ", position: " + position + ", payCheck: " + payCheck;
    }
}
