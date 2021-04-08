package Inheritance.src;

public class Fish extends Animal {
    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    public void rest() {
        System.out.println(this.getName() + " is resting");

    }

    private void moveMuscles() {
        System.out.println(this.getName() + " is moving muscles");
    }

    private void moveBackFin() {
        System.out.println(this.getName() + " is moving back fin");

    }

    public void swim(int speed) {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
}
