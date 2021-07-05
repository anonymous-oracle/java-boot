package com.company;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(everySecondChar("1234567890"));
    }


    public static String everySecondChar(String source) {
//        StringBuilder returnVal = new StringBuilder();
//        for (int i = 0; i < source.length(); i++) {
//            if (i % 2 == 1) {
//                returnVal.append(source.charAt(i));
//            }
//        }
        Function<String, String> returnVal = (str) -> {
            StringBuilder built = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    built.append(source.charAt(i));
                }
            }
            return String.valueOf(built);
        };
        return returnVal.apply(source);
    }
}
