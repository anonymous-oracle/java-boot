
public abstract class Bird extends Animal implements ICanFly {
    public Bird(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");
    }

    // however, bats which are mammals can also fly, so we need an interface for
    // flying
    @Override
    public void fly() {
        System.out.println(this.getName() + " is flapping wings"); // this is a generic action for flying
    }
}
