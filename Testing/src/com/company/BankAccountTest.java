package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Naruto", "Uzumaki", 1000.00, BankAccount.AccountType.CHECKING.getVal());
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail();
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Naruto", "Uzumaki", 1000.00, BankAccount.AccountType.CHECKING.getVal());
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        BankAccount account = new BankAccount("Naruto", "Uzumaki", 1000.00, BankAccount.AccountType.CHECKING.getVal());
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        BankAccount account = new BankAccount("Naruto", "Uzumaki", 1000.00, BankAccount.AccountType.CHECKING.getVal());
//        assertEquals(true, account.isChecking());
        assertTrue("The account is not checking account", account.isChecking());
    }


}
