package InheritanceChallenge.src;

public class Car extends Vehicle{
    private int doors;
    private int seats;
    private String transmission;

    public Car(String name, String model, int gears, int size, int doors, int seats, String transmission){
        super(name, model, 4, gears, size);
        this.doors = doors;
        this.seats = seats;
        this.transmission = transmission;
    }

    public int getDoors(){
        return this.doors;
    }

    public int getSeats(){
        return this.seats;
    }

    public String getTransmissionType(){
        return this.transmission;
    }
}
