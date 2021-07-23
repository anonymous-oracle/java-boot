package com.company;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    // this annotator is used to instantiate necessary variables before any tests are carried out; this method will run before every test method
    public void setup() {
        account = new BankAccount("Naruto", "Uzumaki", 1000.00, BankAccount.AccountType.CHECKING.getVal());
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        double balance = account.withdraw(200, true);
        assertEquals(800, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        assertTrue(account.isChecking(), "The account is not checking account");
    }


//    @Test
//    void testDeposit() {
//    }
//
//    @Test
//    void testWithdraw() {
//    }
//
//    @Test
//    void getBalance() {
//    }
//
//    @Test
//    void isChecking() {
//    }
}
