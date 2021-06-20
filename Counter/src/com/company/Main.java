package com.company;

import java.util.concurrent.CountDownLatch;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread thread1 = new CountdownThread(countdown);
        thread1.setName("Thread 1");
        CountdownThread thread2 = new CountdownThread(countdown);
        thread1.setName("Thread 2");

        thread1.start();
        thread2.start();

    }
}

class Countdown {
    private int i;

    public void doCountdown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ANSI_YELLOW;
                break;
            case "Thread 2":
                color = ANSI_BLUE;
                break;
            default:
                color = ANSI_GREEN;
        }
        for (i = 15; i > 0; i--) { // if int i is not declared then the instance variable 'i' will be used and both threads will have access to the same instance variable
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        this.threadCountdown = countdown;
    }

    @Override
    public void run() {
        this.threadCountdown.doCountdown();
    }
}