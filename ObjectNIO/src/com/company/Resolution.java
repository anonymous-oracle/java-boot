package com.company;

import java.io.Serializable;

public class Resolution implements Serializable {
    private int width;
    private int height;
    private int serialVersionUID;

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
        this.serialVersionUID = this.hashCode();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public int hashCode() {
        return String.valueOf(this.height + this.width).hashCode();
    }
}
