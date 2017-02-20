package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int depositAmount) {
        balance += depositAmount;
    }

    public int balance() {
        return balance;
    }

    public void withdraw(int withdrawAmount) {
        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
        }
    }
}
