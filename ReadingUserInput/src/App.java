package ReadingUserInput.src;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birth year: ");
        int birthYear = scanner.nextInt();
        System.out.println("Enter your name: ");
        scanner.nextLine(); // to avoid skipping the buffer due to carriage return
        String name = scanner.nextLine();

        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + (2020 - birthYear));
        // always close the scanner
        scanner.close();
    }
}
