package ReadingInputChallenge.src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int num;
        boolean isNum;

        Scanner scanner = new Scanner(System.in);
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            System.out.println("Entered number " + i + " : ");
            isNum = scanner.hasNextInt();
            if (isNum) {
                num = scanner.nextInt(); // read only if .hasNextInt() returns true
                sum += num;
                i++;
            } else {
                System.out.println("Enter a valid number");
            }
            scanner.nextLine();
        }
        scanner.close();
    }
}
