package com.company;

import java.io.*;

public class Main {
    private static String filename = "regex.dat";

    public static void main(String[] args) throws IOException {
        DataInputStream dis = null;
        boolean eof = false;
        byte[] data = new byte[8];
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
            while (!eof) {
                String buff = "";
                try {
                    if (dis.read(data) != -1) {
                        for (byte chunk : data) {
                            buff += (char) chunk;
                        }
                        System.out.println(buff);
                    } else {
                        eof = true;
                    }
                } catch (EOFException e) {
                    eof = true;
                    dis.close();
                }
            }
        } catch (IOException e) {
            if (dis != null) {
                dis.close();
            }
            e.printStackTrace();
        }
    }
}
