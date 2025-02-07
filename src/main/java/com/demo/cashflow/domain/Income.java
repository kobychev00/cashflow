package com.demo.cashflow.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Income extends Transaction {
    private Set<Integer> sourceNumbers;

    public Income(Calendar date, int initialTypeNumber, double sum, int initialSourceNumber) {
        super(date, initialTypeNumber, sum);
        this.sourceNumbers = new HashSet<>(List.of(initialSourceNumber));
    }

    public Set<Integer> getSourceNumbers() {
        return sourceNumbers;
    }
}