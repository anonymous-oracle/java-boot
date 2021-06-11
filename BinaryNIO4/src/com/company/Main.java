package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
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
        long end = readChannel.size();
        Collections.reverse(positions);
        positions.forEach((pos) -> {
            ByteBuffer buff2 = ByteBuffer.allocate((int) (end - pos));
            try {
                readChannel.read(buff2);
                buff2.flip();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            byte[] strBytes = new byte[buff2.limit()];
//            buff2.get(strBytes);
//            buff2.flip();
//            System.out.print(new String(strBytes));
            try {
                writeChannel.write(buff2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buff2.flip();
        });
        readChannel.close();
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
