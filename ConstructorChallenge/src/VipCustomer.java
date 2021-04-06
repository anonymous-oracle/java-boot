package ConstructorChallenge.src;

public class VipCustomer {
    private String customerName;
    private float creditLimit;
    private String emailAddress;

    VipCustomer(String customerName, double creditLimit, String emailAddress) {
        this.customerName = customerName;
        this.creditLimit = (float) creditLimit;
        this.emailAddress = emailAddress;
    }

    VipCustomer() {
        this("unknown", 10000.0, "email@email.com");
        System.out.println("No parameters");

    }

    VipCustomer(String customerName, double creditLimit) {
        this(customerName, creditLimit, "email@email.com");
        System.out.println("Two parameters");

    }
}
