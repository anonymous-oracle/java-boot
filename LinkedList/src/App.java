import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Customer customer = new Customer("customer 1", 54.96);
        Customer anotherCustomer = customer;
        anotherCustomer.setBalance(60);
        System.out.println("customer balance: " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
        intList.add(1, 2);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
    }
}
