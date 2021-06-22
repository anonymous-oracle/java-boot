package com.company;

import java.util.Random;

//DEMONSTRATING CONSUMER AND PRODUCER METHODS
public class Main {

    public static void main(String[] args) {

    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (this.empty) {
// empty while loop where the thread will wait for the lock
        }
        this.empty = true;
        return this.message;
    }

    public synchronized void write(String message) {
        while (!this.empty) {

        }
        this.empty = false;
        this.message = message;
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };
        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
            message.write("Finished");
        }
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();

    }
}