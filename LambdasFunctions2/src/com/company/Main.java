package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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


// CREATING A CHAINED FUNCTION
        Function<Employee, String> getName = employee -> employee.getName();
        Function<String, String> getLastLetter = name -> name.substring(name.length() - 1);
        Function age = getName.andThen(getLastLetter); // getName.compose() works in the reverse direction where the function passed as the argument runs first and then the function to which it is being passed

//        for (Employee employee : employees) {
//            System.out.println(age.apply(employee));
//        }
        System.out.println(age.apply(employees.get(new Random().nextInt(employees.size()))));

//        USING A BiFunction
        BiFunction<Employee, String, String> concatNameAndAge = (Employee employee, String name) -> name + " - " + employee.getAge();

//        UNARY OPERATOR
        IntUnaryOperator incBy5 = i -> i + 5;
        int v = new Random().nextInt(employees.size());
        System.out.println(v + " incremented by 5 is: " + incBy5.applyAsInt(v));

//        CONSUMERS
        Consumer<String> c1 = s -> s.toUpperCase(); // the Consumer does not return any value, so the uppercase string will not be returned
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World"); // prints Hello World; so there is no point in chaining together consumers

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