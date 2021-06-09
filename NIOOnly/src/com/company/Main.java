package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        FileChannel channel = null;
        try {
            ByteBuffer buff = ByteBuffer.allocate(8);
            channel = new FileInputStream("regex.dat").getChannel();
            try {
                Charset charset = Charset.forName("utf-8");
                while (channel.read(buff) > 0) {
                    buff.rewind(); // rewind is necessary after every read/write operation with the buffer to set the location of the buffer to 0
                    System.out.print(charset.decode(buff));
                    buff.rewind();
                }
            } catch (Exception e) {
                e.printStackTrace();
                channel.close();
            }
        } catch (Exception e) {
            if (channel != null) {
                channel.close();
            }
            e.printStackTrace();
        }
    }
}
