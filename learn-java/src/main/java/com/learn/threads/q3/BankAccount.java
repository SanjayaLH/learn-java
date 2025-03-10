package com.learn.threads.q3;

import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount, String user) {
        if (amount > 0) {
            balance += amount;
            System.out.println(user + " deposited " + amount + " new balance is: " + balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }

    }

    public synchronized void withdraw(double amount, String user) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(user + " withdraw " + amount + " new balance is: " + balance);
            } else {
                System.out.println(user + " trying to withdraw " + amount + " and no enough balance : " + balance);
                throw new AccountException("Cannot withdraw, balance is not enough.");
            }
        } else {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }

    }

}
