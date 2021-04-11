package src;

// Inheritance is described as a "is a relationship"
// Composition is described as a "has a relationship"
public class App {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 10);
        Case theCase = new Case("220B", "Dell", "240", dimensions);
        Monitor theMonitor = new Monitor("27-inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        // now suppose we want to call a method from the theMonitor instance
        thePC.getCase().pressPowerButton();
        thePC.getMotherboard().loadProgram("Ubuntu 20.04.1");
        thePC.getMonitor().drawPixelAt(1500, 1200, "blue");

    }
}
