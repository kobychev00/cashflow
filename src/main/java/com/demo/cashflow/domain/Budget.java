package com.demo.cashflow.domain;

public class Budget {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Budget(double balance) {
        this.balance = balance;
    }
}
