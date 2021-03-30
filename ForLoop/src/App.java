package ForLoop.src;

public class App {
    public static void main(String[] args) {
        // System.out.println("10000 at 2% interest = " + calculateInterest(10000,
        // 0.02));
        // for (int i = 1; i <= 10; i++) {
        // System.out.println(calculateInterest(10000, i + 1));

        // }

        // System.out.println("*************************************************");
        // for (int i = 10; i >= 1; i--) {
        // System.out.println(calculateInterest(10000, i + 1));
        // }

        for (int i = 1; i <= 100; i++) {
            if (isPrime(i) ? true : false) {
                System.out.println("Number: " + i + " is prime");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.pow(n, 0.5); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

}
