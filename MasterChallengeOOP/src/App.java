public class App {
    public static void main(String[] args) throws Exception {
        HealthyBurger healthyBurger = new HealthyBurger("Chicken", 6);

        healthyBurger.addAddition("tomato", 2);
        healthyBurger.addAddition("lettuce", 3);
        healthyBurger.addAddition("cheese", 3);
        healthyBurger.addAddition("onions", 4);
        healthyBurger.addAddition("carrot", 4);
        healthyBurger.addAddition("mayonese", 2);

        System.out.println(
                "Healthy Burger: " + healthyBurger.getAdditions() + "\nTotal Price: " + healthyBurger.getTotalPrice());

        DeluxeBurger deluxeBurger = new DeluxeBurger("whole grain", "Grilled chicken");
        System.out.println(
                "Deluxe Burger: " + deluxeBurger.getAdditions() + "\nTotal Price: " + deluxeBurger.getTotalPrice());

    }
}
