package com.series;

public class Series {
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev = 0, curr = 1;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            temp = prev;
            prev = curr;
            curr = temp + curr;
        }

        return curr;
    }
}