package com.company;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<String, String> returnVal = (str) -> {
            StringBuilder built = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 1) {
                    built.append(str.charAt(i));
                }
            }
            return String.valueOf(built);
        };

        System.out.println(everySecondChar(returnVal, "01234567899876543210"));
    }


    public static String everySecondChar(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
