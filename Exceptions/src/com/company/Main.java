package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x, y));
//        System.out.println(divideEAFP(x, y));
//        System.out.println(divide(x, y));
        System.out.println("Enter an integer: ");
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        return new Scanner(System.in).nextInt();
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            return 0;
        } catch (ArithmeticException e){
            System.out.println(e);
            return 0;
        }
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
//        System.out.println("Please enter an integer");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int divideLBYL(int x, int y) { // LBYL: Look Before You Leap
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) { // EAFP: Easy to Ask Forgiveness than Permission
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println(e);
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
