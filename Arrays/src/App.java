public class App {
    public static void main(String[] args) throws Exception {
        // int[] myVariable;
        // myVariable = new int[10];
        /////////////////////////////////////////////////////////
        // int[] myVariable = new int[10];
        /////////////////////////////////////////////////////////
        int[] myIntArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        printArray(myIntArray);
        System.out.println(
                "====================================================================================================");
        myIntArray[5] = 50;
        printArray(myIntArray);
        myIntArray[5] = 6;
        System.out.println(
                "====================================================================================================");
        System.out.println(myIntArray.length);
        double[] myDoubleArray = new double[10];
        System.out.println(myIntArray[5]);
        System.out.println(myIntArray[6]);
        System.out.println(
                "====================================================================================================");
        System.out.println(myIntArray);
        System.out.println(
                "====================================================================================================");
        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] *= myIntArray[i];
        }
        printArray(myIntArray);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }
}
