package com.company;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
//        for reading using nio modules, we use a scanner class
        Path rgxFile = FileSystems.getDefault().getPath("regex.dat");
        Scanner scanner = null;
        try {
            scanner = new Scanner(Files.newBufferedReader(rgxFile));
            boolean eof = false;
            while (scanner.hasNext()) {
                System.out.println((String) scanner.next());
            }
        } catch (IOException e) {
            if (scanner == null) {
                scanner.close();
            }
            e.printStackTrace();
        }
    }
}
