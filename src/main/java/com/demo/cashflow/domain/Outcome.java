package com.demo.cashflow.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Outcome extends Transaction{
    private Set <Integer> categoryNumbers;
    public Outcome(Calendar date, int initialTypeNumber, double sum, int categoryNumber) {
        super(date, initialTypeNumber, sum);
        this.categoryNumbers = new HashSet<>(List.of(categoryNumber));
    }

    public Set<Integer> getCategoryNumbers() {
        return categoryNumbers;
    }

    public void setCategoryNumbers(Set<Integer> categoryNumbers) {
        this.categoryNumbers = categoryNumbers;
    }
}
