package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        printFile(FileSystems.getDefault().getPath("files/subdirectory.txt"));
        printFile(FileSystems.getDefault().getPath("files", "subdirectory.txt"));
//        printFile(FileSystems.getDefault().getPath("../workingdirectory.txt"));
        Path filePath = FileSystems.getDefault().getPath("..", "workingdirectory.txt");
        printFile(filePath);
        filePath = Paths.get(".").toAbsolutePath();
        System.out.println(filePath);

        filePath = Paths.get(".", "files", "..", ".", "files", "subdirectory.txt").toAbsolutePath();
        System.out.println(filePath);

        filePath = Paths.get(".", "files", "..", ".", "files", "subdirectory.txt").toAbsolutePath().normalize();
        System.out.println(filePath);
        System.out.println("File exists: " + Files.exists(filePath));
//        Files.copy(filePath, Paths.get(filePath.getParent().toString(), "copy.txt"));
        Files.copy(filePath, Paths.get(filePath.getParent().toString(), "copy.txt"), StandardCopyOption.REPLACE_EXISTING); // similar operations is possible on directories
        Path fileToMove = FileSystems.getDefault().getPath("..", "workingdirectory.txt").toAbsolutePath().normalize();
        Path fileDestination = FileSystems.getDefault().getPath(".", "workingdirectory.txt").toAbsolutePath().normalize(); // destination should also contain the
        Files.move(fileToMove, fileDestination, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(fileDestination, fileToMove);

        Files.delete(fileDestination);
        Files.list(fileDestination.getParent());
    }

    private static void printFile(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while ((line = reader.readLine()) != null) { // this assignment expression will give the value that was assigned to the variable
            System.out.println(line);
        }
        System.out.println();
    }
}
