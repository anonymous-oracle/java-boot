package com.company;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Main {
    private static String characters = "";
    private static String scrambledString = "";

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = null;
        Path rgxFile= FileSystems.getDefault().getPath("regex.dat");
        try {
            bw = Files.newBufferedWriter(rgxFile);
            for (int i = 0; i < 10; i++) {
                initCharacterString();
                String text = getScrambledString(10, 5);
                byte[] bytes = text.getBytes();
//                for (byte aByte : bytes) {
//                    bw.write();
//                }
                for (int i1 = 0; i1 < bytes.length; i1++) {
                    bw.write(bytes[i1]);
                }
                bw.write("\n");
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
