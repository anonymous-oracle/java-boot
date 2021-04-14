import java.lang.reflect.Array;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // Demonstrating reference vs value types
        int myIntValue = 10;
        int anotherValue = myIntValue;
        System.out.println(myIntValue);
        System.out.println(anotherValue);
        anotherValue++;
        System.out.println(myIntValue);
        System.out.println(anotherValue);

        int[] myIntArray = new int[5]; // this holds a reference to the object
        int[] anotherArray = myIntArray;
        anotherArray[3] = 4;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArray));
        myIntArray[0] = 10;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArray));
        modifyArray(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArray));
    }
    private static void modifyArray(int[] array){
        array[0]=2;
    }
}
