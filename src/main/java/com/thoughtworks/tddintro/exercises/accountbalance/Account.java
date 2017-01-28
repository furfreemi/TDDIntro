package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private int balance;

    public Account(){
        this(0);
    }

    public Account(int i) {
        this.balance = i;
    }

    public void deposit(int i) {
        balance += i;
    }

    public int balance() {
        return balance;
    }
}
