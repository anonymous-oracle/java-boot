public class ContactClass {
    private String name;
    private String number;

    public ContactClass(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }
    
    public String representationString() {
        return "NAME: " + this.name + "; " + "NUMBER: " + this.number;
    }
}
