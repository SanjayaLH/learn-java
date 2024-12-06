package com.learn.questions.oop.q3;

import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew " + amount + ". New balance: " + balance);
            } else {
                throw new AccountException("Insufficient funds, transaction failed.");
            }
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "Asela", 1000.00);

        account.deposit(500.00);
        //account.deposit(-500.00);
        //account.withdraw(2000.00);
        account.withdraw(300.00);

        System.out.println("Current balance: " + account.getBalance());
    }

}
