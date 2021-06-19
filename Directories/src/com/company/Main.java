package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Iterator;
import java.util.function.Predicate;

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


////    COPYING A DIRECTORY RECURSIVELY
//        Path copyPath = FileSystems.getDefault().getPath(mainDir.toString(),  "copyDir1");
//        System.out.println("Copy destination is: " + copyPath);
//        try {
//            Files.walkFileTree(mainDir, new CopyFiles(mainDir, copyPath));
//            System.out.println("Successfully copied dir1 to copyDir1");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        MAPPING IO TO NIO UTILITIES
        File file = new File("io.txt"); // according to io utilities the File instance is created
        Path ioFileToNioPath = file.toPath(); // the File instance is then converted to nio Path
        System.out.println(ioFileToNioPath);


        File parent = new File("examples");
        File resolvedFile = new File(parent, "dir");
        System.out.println(resolvedFile.toPath());

//        THE ABOVE EXAMPLE CAN BE EQUIVALENTLY
        File file2 = new File("examples", "dir");
        System.out.println(file2.toPath());

//        THE SAME CAN BE ACHIEVED USING NIO
        Path parentPath = Paths.get("examples");
        Path childPath = Paths.get("dir");
        parentPath = parentPath.resolve(childPath);
        System.out.println(parentPath);

//        DELETING AND RENAMING FILES USING io AND nio
        File cwd = new File("").getAbsoluteFile(); // returns the absolute path of the current working directory
        System.out.println("Working directory: " + cwd);

//        LISTING DIRECTORY CONTENTS USING io AND nio
        File list = new File(String.valueOf(cwd));
        String[] contents = list.list();
        System.out.println("Items in " + cwd + ": ");
        for (int i = 0; i < contents.length; i++) {
            System.out.println((i + 1) + ". " + contents[i]);
        }

        File[] fileList = list.listFiles(); // returns array of File objects instead of String objects
        System.out.println("Items in " + cwd + ": ");
        for (int i = 0; i < fileList.length; i++) {
            System.out.println((i + 1) + ". " + fileList[i]);
        }
    }
}
