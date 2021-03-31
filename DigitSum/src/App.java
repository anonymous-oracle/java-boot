package DigitSum.src;

public class App {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(5195196));
        System.out.println(sumOfDigits(0));
        System.out.println(sumOfDigits(-5195196));
    }

    public static int sumOfDigits(int num) {
        if (num < 0) {
            return -1;
        }
        int rem, quo;
        int sum = 0;
        while (num != 0) {
            rem = num % 10;
            num = (int) num / 10;
            sum += rem;
        }
        return sum;
    }
}
