package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

public class Main {

    public static void main(String[] args) {


        Employee e1 = new Employee("E1", 1);
        Employee e2 = new Employee("E2", 2);
        Employee e3 = new Employee("E3", 3);
        Employee e4 = new Employee("E4", 4);
        Employee e5 = new Employee("E5", 5);
        Employee e6 = new Employee("E6", 6);
        Employee e7 = new Employee("E7", 7);
        Employee e8 = new Employee("E8", 8);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e4);
        employees.add(e3);
        employees.add(e2);
        employees.add(e8);
        employees.add(e5);
        employees.add(e7);
        employees.add(e6);


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