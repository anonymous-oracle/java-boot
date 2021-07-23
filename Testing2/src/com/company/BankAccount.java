package com.company;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public double deposit(double amount, boolean branch) {
        this.balance += amount;
        return balance;
    }

//    the branch argument is true if the customer is performing the transaction at the branch
//    it is false if the customer is performing the transaction at an ATM

    //    the branch argument is true if the customer is performing the transaction at the branch
//    it is false if the customer is performing the transaction at an ATM
    public double withdraw(double amount, boolean branch) {
        this.balance -= amount;
        return this.balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean isChecking() {
        return this.accountType == AccountType.CHECKING.val;
    }

    public static enum AccountType {
        CHECKING(1), SAVINGS(2);

        private int val;

        AccountType(int i) {
            this.val = i;
        }

        public int getVal() {
            return this.val;
        }
    }
}
