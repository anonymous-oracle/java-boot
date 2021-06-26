package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock(); // acquirable lock

//        ExecutorService executorService = Executors.newFixedThreadPool(3); // The callable object runs after the producer and consumer runnables finish running
        ExecutorService executorService = Executors.newFixedThreadPool(5); // since there are 5 threads in threadPool, the producer, consumer runnables and the callable all start at the same time

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the callable class");
                return "This is the callable result";
            }
        });
        try {
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

//        however we need to terminate the executorService manually
        executorService.shutdown(); // this call will wait for any executing threads to terminate and then terminates
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            System.out.println(this.color + "Adding..." + num);
            bufferLock.lock(); // if a thread has already acquired a lock, then the next thread trying to acquire the lock will be suspended until the lock becomes available
            try { // if the try block executes or doesn't execute, the finally block will always execute and call the unlock method
                this.buffer.add(num);
            } finally {
                bufferLock.unlock();
            }
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.color + "Adding EOF and exiting...");
        bufferLock.lock(); // the number of times a thread acquires a lock is the same number of times that it should release a lock
        try {
            this.buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        int counter = 0;
        while (true) {
            if (bufferLock.tryLock()) { // tries to acquire lock if free and returns true, else false
                try {
                    if (this.buffer.isEmpty()) {
                        continue; // 'continue' and 'break' called within a try block exits the current iteration code block and if a 'finally' block is present it executes
                    }
                    System.out.println(color + "The number of trials made to acquire the lock so far: " + counter);
                    counter = 0;
                    if (this.buffer.get(0).equals("EOF")) {
                        System.out.println(this.color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + this.buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }

        }
    }
}