package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

public class Main {

    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            employees.add(new Employee("E" + i, i));
        }
        Collections.shuffle(employees);


//        HOW A FUNCTION INTERFACE IS USED
//        this method of implementing a function logic helps in reducing the usage of an anonymous class and helps use it as a function that returns a value
        Function<Employee, String> getLastLetter = (Employee employee) -> {
            return employee.getName().substring(employee.getName().length() - 1);
        };

        Function<Employee, String> getFirstLetter = (Employee employee) -> {
            return employee.getName().substring(0, 1);
        };

//        employees.forEach(employee -> System.out.println(getLastLetter.apply(employee)));
        int firstLetter = 0, lastLetter = 0;
        for (Employee employee : employees) {
            if (new Random().nextBoolean()) {
                System.out.println("First Letter: " + getFirstLetter.apply(employee));
                firstLetter++;
            } else {
                System.out.println("Second Letter: " + getLastLetter.apply(employee));
                lastLetter++;
            }
        }
        System.out.println("Number of first letters: " + firstLetter);
        System.out.println("Number of last letters: " + lastLetter);

    }

    private static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println("===============================");
        System.out.println(ageText);
        System.out.println("===============================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}