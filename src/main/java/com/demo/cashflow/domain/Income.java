package com.demo.cashflow.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Income extends Transaction {
    private Set <Integer> sourceNumbers;

    public Income(String id, String name, double sum, int sourceNumber) {
        super(id, name, sum);
        this.sourceNumbers = new HashSet<>(List.of(sourceNumber));
    }

    public void setSourceNumbers(Set<Integer> sourceNumbers) {
        this.sourceNumbers = sourceNumbers;
    }
}
