package WhileDoWhile.src;

public class App {
    public static void main(String[] args) {
        int count = 1;
        while (count != 6) {
            System.out.println(count);
            count++;
        }
        System.out.println("============================================================================");

        // WHILE LOOP
        count = 1;
        while (count < 30) {
            System.out.println(count + " is" + (isEven(count) ? " even" : " odd"));
            count++;

        }

        // DO-WHILE LOOP

        count = 1;
        do {
            System.out.println(count + " is" + (isEven(count) ? " even" : " odd"));
            count++;

        } while (count < 30);
    }

    public static boolean isEven(int n) {
        return (n % 2 == 0) ? true : false;
    }
}
