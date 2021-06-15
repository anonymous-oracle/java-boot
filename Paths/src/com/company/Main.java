package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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
        Path fileToCreate = FileSystems.getDefault().getPath("createdfile.txt").toAbsolutePath().normalize();
        Files.delete(fileDestination);
        Files.list(fileDestination.getParent());
        try {
            Files.createFile(fileToCreate);
        } catch (FileAlreadyExistsException e) {

        }
        Path dirToCreate = FileSystems.getDefault().getPath("createddir");
        try {
            Files.createDirectory(dirToCreate);
        } catch (FileAlreadyExistsException e) {

        }
        Files.delete(dirToCreate);
        dirToCreate = FileSystems.getDefault().getPath("dir1/dir2/dir3/dir4/dir5/dir6");
        Files.createDirectories(dirToCreate);
        System.out.println("Size of directory: " + Files.size(dirToCreate));
        System.out.println("Directory last modified: " + Files.getLastModifiedTime(dirToCreate));

        BasicFileAttributes attrs = Files.readAttributes(dirToCreate, BasicFileAttributes.class);
        System.out.println("Size of directory: " + attrs.size());
        System.out.println("Directory last modified: " + attrs.lastModifiedTime());

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
