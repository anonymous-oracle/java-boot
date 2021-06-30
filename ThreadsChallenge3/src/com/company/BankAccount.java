package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private ReentrantLock lock;


    public BankAccount(String accountNumber, double initialBalance, ReentrantLock lock) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = lock;
    }

    public void deposit(double amount) {
        try {
            if (this.lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance += amount;
                } finally {
                    this.lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(double amount) {
        try {
            if (this.lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance -= amount;
                } finally {
                    this.lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}
