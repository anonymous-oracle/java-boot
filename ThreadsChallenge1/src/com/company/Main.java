package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BankAccount jointAccount = new BankAccount("1561985", 100);

        Thread accountHolder1 = new Thread(new Runnable() {
            public void run() {
                jointAccount.deposit(100);
                jointAccount.withdraw(50);
            }
        });

        Thread accountHolder2 = new Thread(new Runnable() {
            public void run() {
                jointAccount.deposit(150);
                jointAccount.withdraw(60);
            }
        });
        accountHolder1.start();
        accountHolder2.start();
        System.out.println("Account balance: " + jointAccount.getBalance());
    }
}
