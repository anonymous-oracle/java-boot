package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
//            bitwise 'OR (|)' operator is used to chain multiple exception catches in one catch block
        } catch (ArithmeticException | NoSuchElementException e) { // catches the error thrown from the divide function
            System.out.println(e.toString());
            System.out.println("unable to perform division; shutting down");
        }
    }

    private static int divide() {
        int x, y;
//        try {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("no suitable input");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("attempted divide by zero");
//        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
//                repeat and read past the newline return of the previous input
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }
}
