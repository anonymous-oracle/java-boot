package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
            String myString = "Split this into an array.";
            String[] parts = myString.split(" ");
            Arrays.stream(parts)
                    .forEach(System.out::println);
        }).start();
    }
}
