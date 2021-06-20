package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_YELLOW + "Hello from " + Thread.currentThread().getName());
        Thread thread = new AnotherThread();
        thread.setName("==Another Thread==");
//        thread.run(); // calling run() instead of start() will make the thread run on a different thread than what the main() thread runs on i.e., it does not branch off of the main thread
        thread.start(); // cannot run the same instance of the thread more than once
//        new AnotherThread().start();

        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from anonymous Thread class")).start();

        Thread runnableThread = new Thread(new MyRunnable()); // Runnable implementations should be used in a thread
        runnableThread.start();

       Thread runnable = new Thread(new MyRunnable() { // anonymous classes using the same class name have access to the original class with the same name through the super() keyword
            @Override
            public void run() {
//                super.run();
                System.out.println(ANSI_CYAN + "Hello from MyRunnable anonymous class");
                try {
//                    thread.join(); // waits for thread execution to complete
                    thread.join(2000); // waits for MyRunnable thread to terminate or time outs to terminate itself, whichever occurs first
                    System.out.println("Finished waiting, " + thread.getName() + " joined");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + Thread.currentThread().getName() + " could not wait for " + thread.getName() + " to finish");
                }
            }
        });
       runnable.start();
//       runnable.interrupt(); // to simulate the thread instance timing out and finish waiting for runnable to terminate
//        thread.interrupt();  // interrupts a thread so that it can handle an interrupt exception accordingly


        System.out.println(ANSI_YELLOW + "Hello again from " + Thread.currentThread().getName());
//        thread.start(); // will throw an error


    }
}
