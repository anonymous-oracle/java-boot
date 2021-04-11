package src;

// Now notice the difference - instead of inheriting using extends, we simply use the classes as datatypes
// by using many of them we build a composit Class
public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard){
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public Case getCase() {
        return this.theCase;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public Motherboard getMotherboard(){
        return this.motherboard;
    }
}
