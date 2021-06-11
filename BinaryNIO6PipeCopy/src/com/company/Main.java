package com.company;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Runnable writer = new Runnable() {
            @Override
            public void run() {
                Pipe.SinkChannel sinkChannel = pipe.sink();
                ByteBuffer buff = ByteBuffer.allocate(56);
                for (int i = 0; i < 10; i++) {
                    String currentTime = "The time is: " + System.currentTimeMillis();
                    buff.put(currentTime.getBytes());
                    buff.flip();
                    while (buff.hasRemaining()) {
                        try {
                            sinkChannel.write(buff);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    buff.flip();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Runnable reader = new Runnable() {
            @Override
            public void run() {
                Pipe.SourceChannel sourceChannel = pipe.source();
                ByteBuffer buff = ByteBuffer.allocate(56);
                for (int i = 0; i < 10; i++) {
                    int bytesRead = 0;
                    try {
                        bytesRead = sourceChannel.read(buff);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    buff.flip();
                    byte[] timeString = new byte[bytesRead];
                    buff.get(timeString);
                    System.out.println("Reader thread: " + new String(timeString));
                    buff.flip();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(writer).start();
        new Thread(reader).start();
    }
}
