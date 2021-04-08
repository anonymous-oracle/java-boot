package Inheritance.src;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    // this will be an internal method which will be wrapped by a public method
    private void chew() {
        System.out.println(this.getName() + " is chewing food");
    }

    // the method override for eat() of the Animal class
    @Override
    public void eat() {
        chew();
        // super.eat(); // demonstrate the method being called
    }

    public void walk() {
        System.out.println(this.getName() + " is walking");
        super.move(5);
    }

    public void run() {
        System.out.println(this.getName() + " is running");
        move(10);
    }

    // move() and super.move() is different super.move() calls to the inherited
    // class
    // whereas move() calls the extended class

    private void moveLegs(int speed) {
        System.out.println(this.getName() + " is moving legs at " + speed);
    }

    @Override
    public void move(int speed) {
        System.out.println(this.getName() + " is moving at " + speed);
        moveLegs(speed);
    }

}
