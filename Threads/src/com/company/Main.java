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

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous Thread class");
            }
        }.start();

        Thread runnableThread = new Thread(new MyRunnable()); // Runnable implementations should be used in a thread
        runnableThread.start();

        new Thread(new MyRunnable() { // anonymous classes using the same class name have access to the original class with the same name through the super() keyword
            @Override
            public void run() {
//                super.run();
                System.out.println(ANSI_CYAN + "Hello from MyRunnable anonymous class");
            }
        }).start();


        System.out.println(ANSI_YELLOW + "Hello again from " + Thread.currentThread().getName());
//        thread.start(); // will throw an error


    }
}
