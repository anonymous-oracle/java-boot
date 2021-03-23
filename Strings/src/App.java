package Strings.src;

public class App {
    public static void main(String[] args) {
        String myString = "This is a string";
        System.out.println("myString is: " + myString);
        myString = myString + " with something more";
        System.out.println("myString is: " + myString);
        myString = myString + "\n\u00a9 2021";
        System.out.println("myString is: " + myString);

        String numbeString = "250.55";
        numbeString = numbeString + "49.95";
        System.out.println(numbeString);
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt; // int will be appended to the string
        System.out.println(lastString);
        double doubleNumber = 120.47d;
        lastString = lastString + doubleNumber;
        System.out.println(lastString);

    }
}
