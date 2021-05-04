import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // ArrayList items = new ArrayList(); // initializing array list without a type, will cause errors
        ArrayList<Integer> items = new ArrayList<Integer>(); 
        items.add(1);
        items.add(2);
        items.add(3);
        // items.add("hello"); // along with integers, String type data can be added to the array list if type
        //                     // of the element in not specified; this will cause errors
        items.add(4);
        items.add(5);
        printDouble(items);
    }

    private static void printDouble(ArrayList n) {
        for (Object i : n) {
            System.out.println((Integer) i * 2);
        }

    }
}
