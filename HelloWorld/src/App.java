package HelloWorld.src;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int myFirstNumber = 5 + 10 * 2 + 1 * (10000 / 2 + 3) - 100;
        int mySecondNumber = 6;
        int myThirdNumber = 7;
        int sumTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        System.out.println(sumTotal);
        int myLastOne = sumTotal - 10;
        System.out.println(myLastOne);
    }
}
