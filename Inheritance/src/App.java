package Inheritance.src;

public class App {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 5, 20);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
        dog.eat();
        dog.run();
        dog.walk();
        dog.move(12);

        Fish fish = new Fish("gold fish", 1, 3, 2, 2, 5);
        fish.swim(5);
        fish.rest();
    }
}
