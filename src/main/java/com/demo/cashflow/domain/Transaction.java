package com.demo.cashflow.domain;

import java.util.Set;

public class Transaction {
    private String name;
    private double sum;

    public Transaction(String name, double sum) {
        this.name = name;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
