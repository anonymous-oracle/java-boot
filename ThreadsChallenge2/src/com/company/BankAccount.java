package com.company;

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
        this.lock.lock();
        try {
            this.balance += amount;
        } finally {
            this.lock.unlock();
        }
    }

    public void withdraw(double amount) {
        this.lock.lock();
        try {
            this.balance -= amount;
        } finally {
            this.lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}
