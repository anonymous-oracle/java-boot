package ParsingValuesFromString.src;

public class App {
    public static void main(String[] args) {
        String numberAsString = "2018";
        System.out.println(("numberAsString=" + numberAsString));

        int number = Integer.parseInt(numberAsString);
        System.out.println("number= " + number);

        // observe how the following operations affect the data
        numberAsString += 1;
        number += 1;

        System.out.println(numberAsString);
        System.out.println(number);
    }
}
