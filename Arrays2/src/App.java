// package Arrays2.src;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int[] myIntegers = getIntegers(5);
        printArray(myIntegers);
        System.out.println("The average of the array is: " + getArrayAverage(myIntegers));
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values: ");
        int[] values = new int[number];
        for (int i = 0; i < number; i++) {
            values[i] = scanner.nextInt();
        }
scanner.close();
        return values;
    }

    public static void printArray(int[] arr) {
        System.out.println("Array elements are: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }

    public static double getArrayAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}
