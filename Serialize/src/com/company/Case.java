package com.company;

import java.io.Serializable;

public class Case implements Serializable {
    private String model;
    private String manufacturer;
    private String powerSupply;
    private Dimensions dimensions;

    private int serialVersionUID;

    public Case(String model, String manufacturer, String powerSupply, Dimensions dimensions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensions;
        this.serialVersionUID = this.hashCode();
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }

    public String getModel() {
        return this.model;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getPowerSupply() {
        return this.powerSupply;
    }

    public Dimensions getDimensions() {
        return this.dimensions;
    }

    @Override
    public int hashCode() {
        return (this.getModel() + this.getManufacturer()).hashCode();
    }

}
