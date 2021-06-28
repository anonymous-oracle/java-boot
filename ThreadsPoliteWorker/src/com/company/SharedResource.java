package com.company;

public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return this.owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
