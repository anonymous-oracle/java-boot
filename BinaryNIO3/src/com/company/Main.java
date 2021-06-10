package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    private static String characters = "";
    private static String scrambledString = "";
//    private static final int BUFF_SIZE = 256;

    public static void main(String[] args) throws IOException {
        FileChannel inputChannel = new FileOutputStream("regex.dat").getChannel();
        byte[] bytes = new byte[0];
        for (int i = 0; i < 10; i++) {
            initCharacterString();
            String text = getScrambledString(50, 7);
            bytes = extendByteArray(text.getBytes(), bytes);
        }
        inputChannel.write(ByteBuffer.wrap(bytes));
        inputChannel.close();

    }

    private static byte[] extendByteArray(byte[] src, byte[] dst) {
        byte[] temp = new byte[src.length + dst.length];
        for (int i = 0; i < src.length; i++) {
            temp[i] = src[i];
        }
        for (int i = src.length; i < src.length + dst.length; i++) {
            temp[i] = src[i - src.length];
        }
        return temp;
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
