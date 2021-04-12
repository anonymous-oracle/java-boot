public class DeluxeBurger extends HamBurger{
    public DeluxeBurger(String bread, String meat){
        super(bread, meat, 12, 2);
        this.addAddition("chips", 0);
        this.addAddition("chips", 0);
    }
}
