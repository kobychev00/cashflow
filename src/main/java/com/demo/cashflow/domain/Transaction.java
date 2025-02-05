package com.demo.cashflow.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.print.DocFlavor;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transaction {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "Europe/Moscow")
    private Calendar date;
    private String name;
    private double sum;

    public Transaction(Calendar date, String name, double sum) {
        this.date = date;
        this.name = name;
        this.sum = sum;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        this.date = new GregorianCalendar(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
