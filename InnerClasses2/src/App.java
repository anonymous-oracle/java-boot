public class App {
    public static void main(String[] args) {
        Gearbox bike = new Gearbox(6);
        bike.addGear(1, 5.3);
        bike.addGear(2, 10.6);
        bike.addGear(3, 15.9);
        bike.operateClutch(true);
        bike.changeGear(1);
        bike.operateClutch(false);
        System.out.println(bike.wheelSpeed(1000));
        bike.changeGear(2);
        System.out.println(bike.wheelSpeed(3000));
        bike.operateClutch(true);
        bike.changeGear(3);
        bike.operateClutch(false);
        System.out.println(bike.wheelSpeed(6000));
    }
}
