package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


// TO IMPLEMENT A COPY OPERATION THAT IS RECURSIVE
public class CopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("Relativized path: " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path: " + copyDir);
        try {
            Files.copy(file, copyDir);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException { // first copies the directory to the destination
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("Relativized path: " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path: " + copyDir);
        try {
            Files.copy(dir, copyDir);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE; // skips copying a subtree i.e., a sub-directory
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//        return super.visitFileFailed(file, exc);
        System.out.println("Error acessing file: " + file.toAbsolutePath() + "\t" + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
