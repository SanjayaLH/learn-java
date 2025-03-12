package com.learn.threads.q3;

public class BankDemo {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread depositT1 = new Thread(() -> bankAccount.deposit(100, "Tom"));
        Thread withdrawT1 = new Thread(() -> bankAccount.withdraw(50, "Jim"));
        Thread withdrawT2 = new Thread(() -> bankAccount.withdraw(100, "Ann"));
        Thread depositT2 = new Thread(() -> bankAccount.deposit(200, "Ron"));
        Thread withdrawT3 = new Thread(() -> bankAccount.withdraw(100, "Ann"));

        depositT1.start();
        withdrawT1.start();
        withdrawT2.start();
        depositT2.start();
        withdrawT3.start();

        try {
            depositT1.join();
            withdrawT1.join();
            withdrawT2.join();
            depositT2.join();
            withdrawT3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The current balance is: " + bankAccount.getBalance());
    }

}
