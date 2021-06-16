package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        Path mainDir = FileSystems.getDefault().getPath("dir1");
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

//        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
////        DirectoryStream<Path> contents = Files.newDirectoryStream(dirs, "*txt");
//        DirectoryStream<Path> contents = Files.newDirectoryStream(dirs, filter);
//        for (Path file : contents) {
//            System.out.println(file.getFileName());
//        }

        //        String separator = File.separator; // separator for the file paths in different operating systems
//        System.out.println(separator);

////        CREATING TEMP FILES IN THE OPERATING SYSTEMS DEFAULT TEMP FILE DIRECTORY
//        Path tempFile = Files.createTempFile("javatemp", ".txt");
//        System.out.println("Temp file location: " + tempFile.toAbsolutePath());
//        Files.delete(tempFile.toAbsolutePath());

////        GET FILESTORES ON THE SYSTEM
//        Iterator<FileStore> stores = FileSystems.getDefault().getFileStores().iterator();
//        System.out.println("SYSTEM FILESTORES:");
//        while (stores.hasNext()) {
//            System.out.println(stores.next());
//        }
//        System.out.println("==================================================");
////        NOT ADVISABLE BUT BETTER TO KNOW
//        Iterator<Path> roots = FileSystems.getDefault().getRootDirectories().iterator();
//        System.out.println("SYSTEM ROOTS:");
//        while (roots.hasNext()) {
//            System.out.println(roots.next());
//        }

////    WALK DIRECTORY TREE
//// PRINTING NAMES AS THE WALK RUNS
//        try {
//            Files.walkFileTree(mainDir, new PrintNames());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }


//    COPYING A DIRECTORY RECURSIVELY
        Path copyPath = FileSystems.getDefault().getPath(mainDir.toString(),  "copyDir1");
        System.out.println("Copy destination is: " + copyPath);
        try {
            Files.walkFileTree(mainDir, new CopyFiles(mainDir, copyPath));
            System.out.println("Successfully copied dir1 to copyDir1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
