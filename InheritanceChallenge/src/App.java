package InheritanceChallenge.src;

public class App {
    public static void main(String[] args)  {
        SUV suv = new SUV("my SUV", 6, 10, 5, 7, "auto");
        suv.accelerateBy(50);
        suv.decelerateBy(30);
        suv.changeGearsUp(8);
        suv.accelerateBy(70);
        suv.moveReverse();
        suv.shiftToNeutral();
        suv.changeGearsUp(2);
    }
}
