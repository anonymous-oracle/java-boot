package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> dbz = Arrays.asList(
                "goku",
                "vegeta",
                "cooler",
                "freeza",
                "broly",
                "jiren",
                "beerus",
                "cell",
                "buu",
                "gogeta",
                "shenron",
                "zeno",
                "whis"
        );

        String match = "C";
        int count = (int) dbz.stream()
                .map((str) -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .filter(str -> str.startsWith(match))
                .count();
        System.out.format("Number of elements starting with %s: %d\n", match, count);
    }
}
