package com.company;

import java.io.Serializable;

public class Dimensions implements Serializable {
    private int width;
    private int height;
    private int depth;
    private int serialVersionUID;

    public Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.serialVersionUID = this.hashCode();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getDepth() {
        return this.depth;
    }

    @Override
    public int hashCode() {
        return String.valueOf(this.height + this.width + this.depth).hashCode();
    }
}
