import java.util.Arrays;
import java.util.Scanner;

// find minimum element in the array
public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = getIntegers(size);
        int minElement = findMin(array);
        System.out.println("The minimum element of the array is: " + minElement);
        reverse(array);
        System.out.println("Array after reversing: " + Arrays.toString(array));

    }

    public static void reverse(int[] arr) {
        int temp;
        int maxIndex = arr.length - 1;
        for (int i = 0; i < (maxIndex / 2); i++) {
            temp = arr[i];
            arr[i] = arr[maxIndex - i];
            arr[maxIndex - i] = temp;
        }
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int[] getIntegers(int size) {
        int[] values = new int[size];
        System.out.println("Enter " + size + " values: ");
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double[] getDoubles(int size) {
        double[] values = new double[size];
        System.out.println("Enter " + size + " values: ");
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextDouble();
        }

        return values;
    }

}
