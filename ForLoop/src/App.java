package ForLoop.src;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("10000 at 2% interest = " + calculateInterest(10000, 0.02));
        for (int i = 1; i <= 10; i++) {
            System.out.println(calculateInterest(10000, i + 1));
    
        }

    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

}
