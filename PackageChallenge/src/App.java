import com.series.*;

public class App {
    public static void main(String[] args) {
        int fibn = 10;
        int factn = 10;
        System.out.println(fibn + " fibonacci number is: " + Series.fib(fibn));
        System.out.println("Factorial of " + factn + " is: " + Series.factorial(factn));
    }
}
