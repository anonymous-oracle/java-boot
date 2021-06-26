package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6); // methods called on this object are thread safe
//        ReentrantLock bufferLock = new ReentrantLock(); // no need of buffer lock now

//        ExecutorService executorService = Executors.newFixedThreadPool(3); // The callable object runs after the producer and consumer runnables finish running
        ExecutorService executorService = Executors.newFixedThreadPool(5); // since there are 5 threads in threadPool, the producer, consumer runnables and the callable all start at the same time

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

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
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(this.color + "Adding..." + num);
                this.buffer.put(num);
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.color + "Adding EOF and exiting...");
        try {
            this.buffer.put("EOF"); // put method is locked when the queue is blocked
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {
            synchronized (this.buffer) {
                try {
                    if (this.buffer.isEmpty()) {
                        continue; // 'continue' and 'break' called within a try block exits the current iteration code block and if a 'finally' block is present it executes
                    }
                    if (this.buffer.peek().equals("EOF")) {
                        System.out.println(this.color + "Exiting");
                        break;
// NOTE: BETWEEN DIFFERENT METHOD CALLS OF THE blocking queue A GIVEN THREAD MAY BE SUSPENDED
                    } else {
                        System.out.println(color + "Removed " + this.buffer.take());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}