package InheritanceChallenge.src;

public class Vehicle {
    private String name;
    private String model;
    private int wheels;
    private int gears;
    private int size;

    public Vehicle(String name, String model, int wheels, int gears, int size) {
        this.name = name;
        this.model = model;
        this.wheels = wheels;
        this.gears = gears;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public String getmodel(){
        return this.model;
    }

    public int getWheels(){
        return this.wheels;
    }

    public int getGears(){
        return this.gears;
    }

    public int getsize(){
        return this.size;
    }

}
