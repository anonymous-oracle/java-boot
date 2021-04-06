package ConstructorChallenge.src;

public class App {
    public static void main(String[] args) {
        VipCustomer vip = new VipCustomer("customer 1", 10000, "customer1@email.com");
        VipCustomer vip2 = new VipCustomer("customer 2", 10000);
        VipCustomer vip3 = new VipCustomer();
    }
}
