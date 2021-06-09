package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Path filepath = FileSystems.getDefault().getPath("regex.dat");
        List<String> lines = Files.readAllLines(filepath);
        lines.forEach((line) -> {
            System.out.println(line);
        });
        Files.write(filepath, "New Line\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        lines = Files.readAllLines(filepath);
        lines.forEach((line) -> {
            System.out.println(line);
        });
    }
}
