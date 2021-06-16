package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// THIS IS TO IMPLEMENT A WORKING FILE VISITER
public class PrintNames extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path filePath = file.toAbsolutePath();
        System.out.println(filePath + " is a " + (Files.isRegularFile(filePath) ? "file" : "directory"));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path filePath = dir.toAbsolutePath();
        System.out.println(filePath + " is a " + (Files.isRegularFile(filePath) ? "file" : "directory"));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//        return super.visitFileFailed(file, exc);
        System.out.println("Error acessing file: " + file.toAbsolutePath() + "\t" + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
