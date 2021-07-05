package com.company;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Supplier<String> ilj = () -> "I love Java!";
        String javaStr = ilj.get();
        System.out.println(javaStr);
    }
}
