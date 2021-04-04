package Classes.src;

// public ACCESS MODIFIER ALLOWS EXTERNAL ACCESS TO THE OBJECT VARIABLES AND METHODS
// private ACCESS MODIFIER ALLOWS ONLY THE CLASS TO ACCESS VARIABLES OR METHODS
// protected ALLOWS BOTH CLASS AND IT'S SUBCLASS TO ACCESS THE METHODS AND VARIABLES

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model) {
        this.model = model.toLowerCase();
    }

    public String getModel() {
        return this.model;
    }

}
