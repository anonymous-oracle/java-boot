package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke " + currentThread().getName() + " up");
        }
        System.out.println(ANSI_BLUE + "Three seconds passed and " + currentThread().getName() + " is awake");

    }
}
