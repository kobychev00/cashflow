package com.demo.cashflow.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Outcome extends Transaction{
    private Set <Integer> categoryNumbers;
    public Outcome(String id, String name, double sum, int categoryNumber) {
        super(id, name, sum);
        this.categoryNumbers = new HashSet<>(List.of(categoryNumber));
    }

    public Set<Integer> getCategoryNumbers() {
        return categoryNumbers;
    }

    public void setCategoryNumbers(Set<Integer> categoryNumbers) {
        this.categoryNumbers = categoryNumbers;
    }
}
