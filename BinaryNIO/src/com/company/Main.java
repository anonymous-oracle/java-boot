package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    private static final int BUFF_SIZE = 128;

    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream("regex.dat");
        FileChannel inputChannel = input.getChannel();

        FileOutputStream output = new FileOutputStream("data.dat");
        FileChannel outputChannel = output.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BUFF_SIZE);
        long channelSize = inputChannel.size();
        while (channelSize > 0) {
            inputChannel.read(buff);
            buff.flip(); // sets the buffer position to 0
            channelSize -= BUFF_SIZE;
            if (channelSize > 0) {
                outputChannel.write(buff);
            } else if (channelSize < 0) {
                outputChannel.write(buff.slice(0, (int) (BUFF_SIZE + channelSize)));
            }
            buff.flip();
        }

        input.close();
        inputChannel.close();
        output.close();
        outputChannel.close();
    }
}
