
public class App {
    public static void main(String[] args) {
        Gearbox bike = new Gearbox(6);
        Gearbox.Gear first = bike.new Gear(1, 12.3); // since Gear is an inner class to Gearbox, not creating it through
                                                     // an instance of the Gearbox would result in an error
        // Gearbox.Gear second = new Gearbox.Gear(2, 15.4); // for this to work, Gear should be a static nested class
        // Gearbox.Gear third = new bike.Gear(3, 17.8); // cannot resolve the object because it's not a class property/attribute
        Gearbox.Gear second = bike.new Gear(2, 15.4);
        Gearbox.Gear third = bike.new Gear(3, 17.8);
        System.out.println(first.driveSpeed(1000));
    }
}
