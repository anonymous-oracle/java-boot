package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

public class Main {

    public static void main(String[] args) {


        Employee e1 = new Employee("E1", 1);
        Employee e2 = new Employee("E2", 2);
        Employee e3 = new Employee("E3", 3);
        Employee e4 = new Employee("E4", 4);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e4);
        employees.add(e3);
        employees.add(e2);


        Collections.sort(employees, (Employee emp1, Employee emp2) -> {
            return emp1.getName().compareTo(emp2.getName());
        });

        employees.forEach(employee -> { // HERE THE employee VARIABLE CHANGES IN EACH ITERATION, BUT THE LAMBDA IS ALSO CONSTRUCTED IN EACH ITERATION ACCORDING TO THE employee VARIABLE
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        });

//        LET'S DEMONSTRATE THE SAME WITH THE OLD FOR LOOP
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getName());
            int finalI = i; // this declaration is needed because for the entire loop block, the value of 'i' changes
            new Thread(() -> System.out.println(employees.get(finalI).getAge())).start();

        }

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

        int i = 0;

        UpperConcat uc = new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {

                return s1.toUpperCase() + s2.toUpperCase();
            }
        };
        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());

        i++;
        System.out.println("i = " + i);
        return Main.doStringStuff(uc, "Hello ", "World");

    }

    public void printValue() {
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            WHEN THE LAMBDA IS BUILT, THE VALUE STORED IN THE VARIABLE IN THE SAME SCOPE AS THE LAMBDA WILL BE USED IF THE VARIABLE NAME IS MENTIONED IN THE LAMBDA
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
    }
}

