package FloatAndDouble.src;

public class App {

    static double poundsToKilos(double pounds) {
        return pounds * 0.45359237d;
    }

    public static void main(String[] args) {
        System.out.println("\n<====================PRIMITIVE DATATYPES===================>");

        System.out.println("\n<====================FLOAT DATATYPES===================>\n");
        float myMinFloat = Float.MIN_VALUE;
        float myMaxFloat = Float.MAX_VALUE;
        System.out.println("Float Min Value: " + myMinFloat);
        System.out.println("Float Max Value: " + myMaxFloat);

        System.out.println("\n<====================DOUBLE DATATYPES===================>\n");
        double myMinDouble = Double.MIN_VALUE;
        double myMaxDouble = Double.MAX_VALUE;
        System.out.println("DOuble Min Value: " + myMinDouble);
        System.out.println("DOuble Max Value: " + myMaxDouble);

        int myIntValue = 5 / 2; // decimal part is truncated
        // float myFloatValue = 5.25f; // by default java considers floating point
        // numbers as double; so suffix an 'f'
        // // after a number to indicate it's a 'float' type
        float myFloatValue = (float) 5 / 2f;
        double myDoubleValue = 5d / 2d;

        System.out.println("Int value = " + myIntValue);
        System.out.println("Float value = " + myFloatValue);
        System.out.println("Double value = " + myDoubleValue);

        float myPounds = 200f;
        myPounds = (float) poundsToKilos(myPounds);
        System.out.println((double) myPounds);
    }
}
