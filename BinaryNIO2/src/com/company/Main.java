package com.company;

import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    private static final int BUFF_SIZE = 128;

    public static void main(String[] args) throws Exception {
        RandomAccessFile input = new RandomAccessFile("data.dat", "rwd");
        long channelLength = input.length();
        while (channelLength>0){
            byte[] b = new byte[BUFF_SIZE];
            channelLength -= BUFF_SIZE;
            input.read(b);
            System.out.println(new String(b));
        }
    }
}
