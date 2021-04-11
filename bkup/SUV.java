package InheritanceChallenge.src;

public class SUV extends Car {

    private int speed;
    private byte gearSpeed;

    public SUV(String name, int gears, int size, int doors, int seats, String transmission) {
        super(name, "SUV", gears, size, 5, 7, transmission);
        this.speed = 0;
        this.gearSpeed = 0; // gear 0 means neutral and -1 means reverse
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    private int getSpeed() {
        return this.speed;
    }

    private void setGearSpeed(byte gear) {
        this.gearSpeed = gear;
        System.out.println("Gear changed to " + gear);
    }

    private int getGear() {
        return (int) this.gearSpeed;
    }

    public void accelerateBy(int speed) {
        int currSpeed = this.getSpeed();
        System.out.println("Speed increased from " + currSpeed + " to " + (currSpeed + speed));
        this.setSpeed(currSpeed + speed);

    }

    public void decelerateBy(int speed) {
        int currSpeed = this.getSpeed();
        System.out.println("Speed decreased from " + currSpeed + " to " + (currSpeed - speed));
        this.setSpeed(currSpeed - speed);
    }

    public void brake() {
        this.setSpeed(0);
        this.setGearSpeed((byte) 1);
    }

    public void changeGearsUp(int gear) {
        if (gear > this.getGears()) {
            for (int i = this.getGear(); i <= this.getGears(); i++) {
                this.setGearSpeed((byte) i);
            }
        } else {
            for (int i = this.getGear(); i <= gear; i++) {
                this.setGearSpeed((byte) i);
            }
        }
    }

    public void changeGearsDown(int gear) {
        if (gear < -1) {
            for (int i = this.getGear(); i >= -1; i--) {
                this.setGearSpeed((byte) i);
            }
        } else {
            for (int i = this.getGear(); i >= gear; i--) {
                this.setGearSpeed((byte) i);
            }
        }
    }

    public void moveReverse() {
        this.changeGearsDown(-1);
    }

    public void shiftToNeutral() {
        if (this.getGear() == -1) {
            this.gearSpeed = 0;
        } else {
            for (int i = this.getGear(); i >= 0; i--) {
                this.setGearSpeed((byte) i);
            }
        }
        System.out.println("Gear shifted to Neutral");
    }
}
