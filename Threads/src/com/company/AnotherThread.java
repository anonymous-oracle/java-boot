package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke " + currentThread().getName() + " up from sleep");
            return; // terminates the run method when interrupted
        }
        System.out.println(ANSI_BLUE + "Five seconds passed and " + currentThread().getName() + " is awake");

    }
}
