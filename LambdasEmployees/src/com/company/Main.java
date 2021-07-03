package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
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

        printEmployeeByAge(employees, "Employees over 4", employee -> employee.getAge() > 4); // using lambda expressions as short condition testers using the Predicate interface
        printEmployeeByAge(employees, "Employees 4 and under", employee -> employee.getAge() <= 4);

        printEmployeeByAge(employees, "Employees over 4", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 4;
            }
        }); // using anonymous classes as short condition testers using the Predicate interface
        printEmployeeByAge(employees, "Employees 4 and under", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() <= 4;
            }
        });
//        GENERIC USE OF PREDICATE
        IntPredicate intp = i -> i > 15; // a predicate for Integers; the variable 'i' is within the scope of the lambda expression
        System.out.println(intp.test(20) ? "Value is greater than 15" : "Value is less than or equal to 15");
        System.out.println(intp.test(10) ? "Value is greater than 15" : "Value is less than or equal to 15");
// USE OF SUPPLIER
        Supplier<Integer> randomSupplier = () -> (new Random().nextInt(1000)); // supplier
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

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