package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();


        someBingoNumbers
                .stream()
//                THE map FUNCTION MAPS THE INPUT STREAM ELEMENTS TO THE OUTPUT OF THE FUNCTION REFERENCE IN A CORRESPONDING MANNER
                .map(String::toUpperCase) // the method reference is used to map the elements to the function so that string elements can be converted to uppercase
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println); // the g64 element will be printed as G64 because in the stream sequence, the value is modified by the chained operation and is passed to the next operation


//        CUSTOM STREAM METHOD
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
//        System.out.println(concatStream.count());
        System.out.println("===========================");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println) // prints the element and passes it to the next call which can map to aggregate function like counting the elements in the stream
                .count()); // to get the number of unique elements

        List<Department> departments = new ArrayList<>();
        Department hr = new Department("Human Resources");
        for (int i = 1; i <= 100; i++) {
            hr.addEmployee(new Employee("E-" + i, new Random().nextInt(101)));
        }
        Collections.shuffle(hr.getEmployees());

        Department fin = new Department("Accounting and Finance");
        for (int i = 101; i <= 200; i++) {
            fin.addEmployee(new Employee("E-" + i, new Random().nextInt(101)));
        }
        Collections.shuffle(fin.getEmployees());

        departments.add(hr);
        departments.add(fin);

        departments.stream() // here stream is called on the department list which gives out the department elements
                .flatMap(department -> department.getEmployees().stream()) // using flatmap, we call .stream() on the employees list within the deparment object which streams out the employee elements in both department classes
                .forEach(s -> System.out.println(s.getName()));

//        COLLECT method
        System.out.println("=====================");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s->s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
//                the first argument is a supplier (supplier is something which creates objects for the collector to collect) and then a biconsumer which accumalates the elements to the list if there is a single item to be added during runtime
//                the combiner which is the addAll method is used during runtime to combine multiple elements at one go
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

//        GROUP-BY OPERATION
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge())); // maps a single integer to a list of employees and the collector groups by the age

        System.out.println("=========================");
        System.out.println(groupedByAge);

//        REDUCE METHOD; COMBINES ALL ELEMENTS IN STREAM INTO A SINGLE ITEM
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2) // returns the youngest employee in the stream by continuous comparisons between elements; ternary operation is used because the result has to be an stream element type object
                .ifPresent(System.out::println); // if the youngest employee is present, then it is printed

        List<String> testStringList = new ArrayList<>();
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(e -> e.getName());

        System.out.println("======================");
        Stream.of("cvdfv", "cdsver", "ferve", "efvv", "aedc", "vrsvv")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3; // nothing prints because there is no terminal operation to use the passed on stream
                })
                .count(); // when count was added, a terminal flow of the stream operation concluded and the intermediate operations were taken seriously
    }
}
