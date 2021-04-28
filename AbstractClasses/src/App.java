public class App {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Bird birdRavi = new Pigeon("Bird Ravi"); // notice that the abstract class can be used as a type identifier for an extended class
        birdRavi.breathe();
        birdRavi.eat();
        birdRavi.fly(); 
    }
}