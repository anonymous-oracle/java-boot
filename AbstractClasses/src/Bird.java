

public abstract class Bird extends Animal {
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

    public abstract void fly();
}
