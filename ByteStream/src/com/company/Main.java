package com.company;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static String characters = "";
    private static String scrambledString = "";

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("regex.dat")));
            for (int i = 0; i < 10; i++) {
                initCharacterString();
                String text = getScrambledString(50, 7);
                byte[] bytes = text.getBytes();
//                for (byte aByte : bytes) {
//                    dos.write();
//                }
                dos.write(bytes);
//                dos.write("\n");
            }
            dos.close();
        } catch (IOException e) {
            if (dos != null) {
                dos.close();
            }
            e.printStackTrace();
        }


    }

    private static void initCharacterString() {
        for (char c = 33; c <= 126; c++) {
            if (c != '-') {
                characters += c;
            }
        }
    }

    private static String getScrambledString(int chunks, int chunkLength) {
        String chunk = "";
        String fullString = "";
        Random random = new Random();
        for (int j = 0; j < chunks; j++) {
            for (int i = 0; i < chunkLength; i++) {
                chunk += characters.charAt((int) (random.nextFloat() * characters.length()));
            }
            fullString += chunk;
            if (j != chunks) {
                fullString += "--";
            }
            chunk = "";
        }
        return fullString;
    }

}
