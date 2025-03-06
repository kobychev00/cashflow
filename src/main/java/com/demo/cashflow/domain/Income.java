package com.demo.cashflow.domain;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("INCOME" )
public class Income extends Transaction {
    @ElementCollection
    @CollectionTable(name = "income_sources", joinColumns = @JoinColumn(name = "income_id" ))
    @Column(name = "source_number" )
    private Set<Integer> sourceNumbers;

    public Income() {}

    public Income(Calendar date, double sum, int initialSourceNumber) {
        super(date, 1, sum);
        this.sourceNumbers = new HashSet<>(List.of(initialSourceNumber));
    }

    public Set<Integer> getSourceNumbers() {
        return sourceNumbers;
    }

    @Override
    public String getTransactionType() {
        return "Income";
    }
}