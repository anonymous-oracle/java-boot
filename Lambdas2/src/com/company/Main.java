package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the anonymous runnable");
//            }
//        }).start();

//        new Thread(() -> System.out.println("Printing from the lambda")).start(); // this is a lambda expression
//        new Thread(() -> { // the compiler knows that one of the parameters that could be passed to the thread class is
//            // a Runnable interface which has only one method and this is run(); since the run method also does not accept any parameters, the compiler knows that it should be run as a Runnable method
//            System.out.println("Printing from the lambda"); // this is also a lambda expression
//        }).start();

        Employee e1 = new Employee("E1", 1);
        Employee e2 = new Employee("E2", 2);
        Employee e3 = new Employee("E3", 3);
        Employee e4 = new Employee("E4", 4);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e4);
        employees.add(e3);
        employees.add(e2);


//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                return e1.getName().compareTo(e2.getName());
//            }
//        });
// LAMBDA VERSION
//        Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
        Collections.sort(employees, (Employee emp1, Employee emp2) -> {
            return emp1.getName().compareTo(emp2.getName());
        });

        employees.forEach(employee -> {
            System.out.println(employee.getName());
        });

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "Hello ", "World");

//        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(), "Hello ", "World");
//        System.out.println(sillyString);
////          WE CAN ALSO ASSIGN LAMBDA EXPRESSIONS TO INTERFACES
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//        sillyString = doStringStuff(uc, "Hello ", "World");
//        System.out.println(sillyString);
//
//        uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        sillyString = doStringStuff(uc, "Hello ", "World");
//        System.out.println(sillyString);
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}

class AnotherClass {
    public String doSomething() {
//        UpperConcat uc = (s1, s2) -> {
////            A LAMBDA EXPRESSION HAS THE SAME SCOPE OF THE BLOCK WHICH IT IS NESTED IN
//            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        final int i = 0;
 int i = 0;

//        { // testing the lambda expression scope within a code block
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
//                    the 'i' variable used here belongs to the scope outside the anonymous class and when the class
//                    instance is constructed, the value of i currently outside the scope is used in the class and may not be updated again when the value changes in the block where the anonymous class is nested
//                    System.out.println("i (within the anonymous class) = " + i);
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };
            System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());

            i++;
            System.out.println("i = " + i);
            return Main.doStringStuff(uc, "Hello ", "World");
//        }


//        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is "+getClass().getSimpleName()); // this should not print a name because this is a anonymous class
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "Hello ", "World");
    }
}