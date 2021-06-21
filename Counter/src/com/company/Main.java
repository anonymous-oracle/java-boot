package com.company;

import java.util.concurrent.CountDownLatch;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
//        Countdown countdown1 = new Countdown(); // created to demonstrate absence of interference over different thread objects
//        Countdown countdown2 = new Countdown();

        CountdownThread thread1 = new CountdownThread(countdown);
        thread1.setName("Thread 1");
        CountdownThread thread2 = new CountdownThread(countdown);
        thread1.setName("Thread 2");


//        the thread stack will contain object references and the object values will be on the heap
        thread1.start();
        thread2.start();

    }
}

class Countdown {
    private int i;

    public void doCountdown() {
//    public synchronized void doCountdown() { // adding the 'synchronized' keyword ensures that the method is not available until another thread finishes execution
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
//        local variables such as declaring 'int i' in a loop will use the respective thread's stack space; but when using objects, threads
//        refer to the heap memory, eg., the countdown object instance is the same instance being passed to both threads and the instance variable 'i' is
//        allocated on the heap memory as well; hence the value changed by one thread will reflect to the other thread which tries to access/read the value
//        in a race condition, the problem arises only when at least 1 thread tries to modify the resource; there is no problem for multiple threads reading the same resourcel

//        another way to synchronize is to use an intrinsic block where the variable to be locked is passed to the block; however, primitive datatypes can't be passed to the lock
//        synchronized (color) {
        synchronized (this) { // by synchronizing the countdown object itself, we produce the same effect as using a synchronized function where the first thread will have access to the object until it finishes
//            there will still be some interference in the synchronized block because the color object is a local variable and since the method is called separately in two threads
//            there will be separate variables created in the thread stack
            for (i = 10; i > 0; i--) { // if int i is not declared then the instance variable 'i' will be used and both threads will have access to the same instance variable
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
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