import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // // When using the array list, we cannot use it over primitive datatypes as
        // demonstrated below
        // ArrayList<int> myIntList = new ArrayList<int>(); // this is because the
        // arraylist expects a reference type object

        // an alternative is to use a wrapper class around the primitive datatypes or
        // use the ones provided by default
        ArrayList<Integer> myIntList = new ArrayList<Integer>();
        Integer integer = new Integer(5);
        myIntList.add(integer);
        System.out.println(myIntList);
        myIntList.remove(0);
        System.out.println("Autoboxing...");
        for (int i = 0; i < 10; i++) {
            myIntList.add(Integer.valueOf(i)); // returns a reference type object of Integer having value i; this is
                                               // called autoboxing
        }
        System.out.println("Unboxing...");
        for (int i = 0; i < 10; i++) {
            System.out.println(myIntList.get(i).intValue()); // this is called unboxing
        }

        // SHORTER WAY OF AUTOBOXING/UNBOXING
        Integer newIntValue = 50; // autoboxing; it automatically creates a reference object using the 'new'
                                  // keyword and assigns it; it also performs the Integer.valueOf() operation
        System.out.println("newIntValue = " + newIntValue.intValue());
        int unboxedInt = newIntValue; // behind the scenes, this returns newIntValue.intValue(); and is assigned to
                                      // the unboxedInt variable
    }
}
