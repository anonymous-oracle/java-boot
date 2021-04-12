public class HamBurger {
    private String breadRoll;
    private String meat;
    private int basePrice;
    private int totalPrice;
    private String additions;
    private int numAdditions;
    private int maxAdditions;

    public HamBurger(String bread, String meat, int basePrice, int maxAdditions) {
        this.breadRoll = bread;
        this.meat = meat;
        this.basePrice = basePrice;
        this.totalPrice = this.basePrice;
        this.additions = "Additions: ";
        this.numAdditions = 0;
        this.maxAdditions = maxAdditions;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public int getNumAdditions() {
        return this.numAdditions;
    }

    public int getMaxAdditions() {
        return this.maxAdditions;
    }

    public void addAddition(String addon, int addonPrice) {
        if (this.numAdditions <= this.maxAdditions) {
            this.additions += " " + addon + ": Price - "+addonPrice+",";
            this.totalPrice += addonPrice;
            this.incrementNumAdditions();
        } else {
            System.out.println("Only " + this.maxAdditions + " additions allowed");
        }
    }

    private void incrementNumAdditions() {
        this.numAdditions += 1;
    }

    // public void addTomato() {
    // this.addAddition("Tomato", 2);
    // }

    // public void addLettuce() {
    // this.addAddition("Lettuce", 3);
    // }

    // public void addCarrot() {
    // this.addAddition("Carrot", 4);
    // }

    public String getAdditions() {
        return this.additions;
    }

}
