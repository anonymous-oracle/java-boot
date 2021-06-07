package com.company;

import java.io.Serializable;

// Now notice the difference - instead of inheriting using extends, we simply use the classes as datatypes
// by using many of them we build a composit Class
public class PC implements Serializable {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;
    private int serialVersionUID;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.serialVersionUID = this.hashCode();
    }

    public void powerUp() {
        this.getCase().pressPowerButton();
        this.getMonitor().drawPixelAt(1200, 500, "blue");
        this.getMotherboard().loadProgram("Ubuntu 20.04.1 - Focal Fossa");
    }

    private Case getCase() {
        return this.theCase;
    }

    private Monitor getMonitor() {
        return this.monitor;
    }

    private Motherboard getMotherboard() {
        return this.motherboard;
    }

    @Override
    public int hashCode() {
        return (this.theCase.hashCode() + this.monitor.hashCode() + this.motherboard.hashCode()) * 17;
    }
}
