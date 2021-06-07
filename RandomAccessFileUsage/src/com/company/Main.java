package com.company;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static HashMap<Character, ArrayList<IndexRecord>> indexMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        for RandomAccessFile class refer to the documentation of the code to know how parameters are used and passed
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("regex.dat", "rwd"); // 'rwd' mode writes data to file on the disk synchronously especially when there is multithreaded access
            long startLocation = raf.getFilePointer();
//            System.out.println((char) raf.readByte());
//            raf.seek(startLocation);
//            String str = raf.readLine();
//            int strLen = str.length(); // filepointer moves to last location if file does not have a new line character (if the file is a full string)
//            System.out.println(strLen);
////            System.out.println((char) raf.readByte());
//            raf.seek(startLocation);
//            System.out.println((char) raf.readByte());
//            raf.seek(startLocation + 1); // moves filepointer to next byte
//            System.out.println((char) raf.readByte());
//            System.out.println(str);
//            raf.seek(startLocation);
            boolean eof = false;
            char ch = '0';
            long offset = 0;
            ArrayList<IndexRecord> list;
            try {
                while (!eof) {
                    offset = raf.getFilePointer() - startLocation;
                    ch = (char) raf.readByte();
                    if (indexMap.get(ch) == null) {
                        ArrayList<IndexRecord> newList = new ArrayList<IndexRecord>();
                        newList.add(new IndexRecord(startLocation, offset));
                        indexMap.put(ch, newList);
                    } else {
                        list = indexMap.get(ch);
                        list.add(new IndexRecord(startLocation, raf.getFilePointer() - startLocation));
                    }
                }
            } catch (EOFException e) {
                eof = true;
//                e.printStackTrace();
            }
            raf.seek(startLocation);
            System.out.println(indexMap);
        } catch (IOException e) {
            if (raf != null) {
                raf.close();
            }
            e.printStackTrace();
        }
    }
}
