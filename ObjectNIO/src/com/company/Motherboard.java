package com.company;

import java.io.Serializable;

public class Motherboard implements Serializable {
    private String model;
    private String manufacturer;
    private int ramSlots;
    private int cardSlots;
    private String bios;
    private int serialVersionUID;

    public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
        this.serialVersionUID = this.hashCode();
    }

    public String getModel() {
        return this.model;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getBios() {
        return this.bios;
    }

    public int getRamSlots() {
        return this.ramSlots;
    }

    public int getCardSlots() {
        return this.cardSlots;
    }

    public void loadProgram(String programName){
        System.out.println("Program "+programName+" is now loading...");
    }

    @Override
    public int hashCode() {
        return (this.getModel() + this.getManufacturer()).hashCode();
    }
}
