package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        Path dirs = FileSystems.getDefault().getPath("dir1", "dir2", "dir3", "dir4", "dir5", "dir6", "dir7").normalize().toAbsolutePath();
        try {
            Files.createDirectories(dirs);
            Files.createFile(FileSystems.getDefault().getPath(dirs.toString(), "file.txt"));
        } catch (FileAlreadyExistsException e) {
        }
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() { // allows to only select files and not directories
//            @Override
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path));
//            }
//        };

        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
//        DirectoryStream<Path> contents = Files.newDirectoryStream(dirs, "*txt");
        DirectoryStream<Path> contents = Files.newDirectoryStream(dirs, filter);
        for (Path file : contents) {
            System.out.println(file.getFileName());
        }
    }
}
