package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Challenge {
    private static String characters = "";
    private static String scrambledString = "";

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("regex.txt"));
            for (int i = 0; i < 10; i++) {
                initCharacterString();
                String text = getScrambledString(50, 7);
                bw.write(text);
//                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            if (bw != null) {
                bw.close();
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
