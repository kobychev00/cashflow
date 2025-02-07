package com.demo.cashflow.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.print.DocFlavor;
import java.util.*;

public class Transaction {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "Europe/Moscow")
    private Calendar date;
    private Set<Integer> type;
    private double sum;

    public Transaction(Calendar date, int initialTypeNumber, double sum) {
        this.date = date;
        this.type = new HashSet<>(List.of(initialTypeNumber));;
        this.sum = sum;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        this.date = new GregorianCalendar(year, month, day);
    }

    public Set<Integer> getType (){
        return type;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
