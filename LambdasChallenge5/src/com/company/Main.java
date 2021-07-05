package com.company;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        String str;
        Callable<String> call = () -> "This is a returned String";
    }
}
