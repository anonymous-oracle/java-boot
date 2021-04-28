// ABSTRACT CLASSES CANNOT BE USED AS INSTANCES OF OBJECT; THAT IS THEY CANNOT BE INSTANTIATED
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void breathe(); // abstract methods are meant to be overwritten

    public String getName() {
        return this.name;
    }
}
