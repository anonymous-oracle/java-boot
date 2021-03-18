package ByteShortIntLong.src;

public class App {
    public static void main(String[] args) {
        System.out.println("\n<====================PRIMITIVE DATATYPES===================>");

        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;
        System.out.println("\n<====================INT DATATYPE===================>\n");
        System.out.println("Minimum integer value = " + minIntValue);
        System.out.println("Maximum integer value = " + maxIntValue);
        System.out.println("Minimum integer value with 1000 subtracted from it: " + (minIntValue - 1000));
        System.out.println("Maximum integer value with 1000 added to it: " + (maxIntValue + 1000));
        
        System.out.println("\n<====================BYTE DATATYPE===================>\n");
        byte minByteValue = Byte.MIN_VALUE;
        byte maxByteValue = Byte.MAX_VALUE;
        System.out.println("Minimum byte value = " + minByteValue);
        System.out.println("Maximum byte value = " + maxByteValue);

        System.out.println("\n<====================SHORT DATATYPE===================>\n");
        short minShortValue = Short.MIN_VALUE;
        short maxShortValue = Short.MAX_VALUE;
        System.out.println("Minimum short value = " + minShortValue);
        System.out.println("Maximum short value = " + maxShortValue);

        System.out.println("\n<====================LONG DATATYPE===================>\n");
        long myValue = 10000l; // the 'l' is suffixed to specify that it is a long value
        long minLongValue = Long.MIN_VALUE;
        long maxLongValue = Long.MAX_VALUE;
        System.out.println(myValue);
        System.out.println("Minimum long value = " + minLongValue);
        System.out.println("Maximum long value = " + maxLongValue);
    }
}
