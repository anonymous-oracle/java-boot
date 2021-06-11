package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final int BUFF_SIZE = 16;
    private static String characters = "";
    private static String scrambledString = "";

    public static void main(String[] args) throws IOException {
        FileChannel inputChannel = new FileOutputStream("regex.dat").getChannel();
        ByteBuffer buff;
        ArrayList<Long> positions = new ArrayList<Long>();
        positions.add(0L);
        for (int i = 0; i < 10; i++) {
            initCharacterString();
            String text = getScrambledString(50, 7) + "\n";
            byte[] textBytes = text.getBytes();
            buff = ByteBuffer.wrap(textBytes);
            positions.add(positions.get(positions.size() - 1) + textBytes.length);
            inputChannel.write(buff);
            buff.flip();
        }
        inputChannel.close();

//        READING BACK THE FILE IN REVERSE
        RandomAccessFile ra = new RandomAccessFile("regex.dat", "rwd");
        FileChannel readChannel = ra.getChannel();
        RandomAccessFile ra2 = new RandomAccessFile("data.dat", "rwd");
        FileChannel writeChannel = ra2.getChannel();
        readChannel.position(0); // set position to beginning of the channel
//        writeChannel.transferFrom(readChannel, 0, readChannel.size());
//        can also use transferTo channel
        writeChannel.position(0);
        readChannel.transferTo(0, readChannel.size(), writeChannel);
        readChannel.close();
        writeChannel.close();
    }


    private static void initCharacterString() {
        for (char c = 33; c <= 126; c++) {
            if (c != '-') {
                characters += c;
            }
        }
    }

    private static String getScrambledString(int chunks, int chunkLength) {
        String chunk = "";
        String fullString = "";
        Random random = new Random();
        for (int j = 0; j < chunks; j++) {
            for (int i = 0; i < chunkLength; i++) {
                chunk += characters.charAt((int) (random.nextFloat() * characters.length()));
            }
            fullString += chunk;
            if (j != chunks) {
                fullString += "--";
            }
            chunk = "";
        }
        return fullString;
    }

}
