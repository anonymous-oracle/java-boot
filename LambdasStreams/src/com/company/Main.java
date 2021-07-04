package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


      /*  someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number); // this is because the references to the elements within the array list do not change
                System.out.println(number);
            }
        });
        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
        gNumbers.forEach(s -> System.out.println(s)); */
//        WILL NOW IMPLEMENT THE ABOVE LOGIC OF CODE BLOCK USING STREAMS
//        Function<String, String> upper = String::toUpperCase; // method reference
//        System.out.println(upper.apply("hi"));
//        someBingoNumbers.forEach(System.out::println);

        someBingoNumbers
                .stream()
//                THE map FUNCTION MAPS THE INPUT STREAM ELEMENTS TO THE OUTPUT OF THE FUNCTION REFERENCE IN A CORRESPONDING MANNER
                .map(String::toUpperCase) // the method reference is used to map the elements to the function so that string elements can be converted to uppercase
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println); // the g64 element will be printed as G64 because in the stream sequence, the value is modified by the chained operation and is passed to the next operation


//        CUSTOM STREAM METHOD
        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
    Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
//        System.out.println(concatStream.count());
        System.out.println("===========================");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println) // prints the element and passes it to the next call which can map to aggregate function like counting the elements in the stream
                .count()); // to get the number of unique elements


    }
}
