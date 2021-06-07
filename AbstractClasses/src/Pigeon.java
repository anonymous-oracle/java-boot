public class Pigeon extends Bird implements ICanFly{
    public Pigeon(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly(); // this is a generic action for flying
        System.out.println(this.getName() + " is flying");
    }
}
