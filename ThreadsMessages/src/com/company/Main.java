package com.company;

import java.util.Collections;
import java.util.Random;

//DEMONSTRATING CONSUMER AND PRODUCER METHODS
public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() { // variables local to a method are thread safe because a method called by a thread and the method's local variables are stored on the thread stack
        while (this.empty) {
// empty while loop where the thread will wait for the lock
            try {
//                without the wait call, the lock on the message object or rather the empty variable will not be released as in synchronized methods, thread executions are synchronized to execute one at a time
                wait(); // suspends the control on the empty object by the current thread and allows other awakened thread(s) waiting for control of the object to acquire the lock
            } catch (InterruptedException e) {

            }
        }
        this.empty = true;
        notifyAll(); // call notifyAll() after the empty variable is changed
        return this.message;
    }

    public synchronized void write(String message) {
        while (!this.empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        this.empty = false;
        this.message = message;
        notifyAll(); // call notifyAll() after the message field is set

    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };
        Random random = new Random();
        for (String s : messages) {
            message.write(s);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");

    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for (String latestMessage = this.message.read(); !latestMessage.equals("Finished"); latestMessage = this.message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}