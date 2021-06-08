package com.company;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        PC pc = new PC(new Case("151516", "Cooler Master", "700W SMPS", new Dimensions(10, 20, 15)), new Monitor("Wideview LED 22", "LED", 22, new Resolution(1920, 1080)), new Motherboard("Asus Z-series", "Asus", 8, 12, "v3.74"));
        Path objFileName = FileSystems.getDefault().getPath("PC.obj");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(objFileName)));
            oos.writeObject(pc);
            oos.close();
        } catch (IOException e) {
            if (oos != null) {
                oos.close();
            }
            e.printStackTrace();
        }
//    READING BACK THE OBJECT
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(objFileName)));
            try {
                PC pc2 = (PC) ois.readObject();
                System.out.println("Successfully read back the serialized PC object...");
                pc2.powerUp();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new IOException();
            }
        } catch (IOException e) {
            if (ois != null) {
                ois.close();
            }
            e.printStackTrace();
        }
    }
}
