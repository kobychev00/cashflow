package com.demo.cashflow.domain;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("OUTCOME" )
public class Outcome extends Transaction {

    @ElementCollection
    @CollectionTable(name = "outcome_categories", joinColumns = @JoinColumn(name = "outcome_id" ))
    @Column(name = "category_number" )
    private Set<Integer> categoryNumbers;

    public Outcome () {}

    public Outcome(Calendar date, double sum, int categoryNumber) {
        super(date, 2, sum);
        this.categoryNumbers = new HashSet<>(List.of(categoryNumber));
    }

    public Set<Integer> getCategoryNumbers() {
        return categoryNumbers;
    }

    @Override
    public String getTransactionType() {
        return "Outcome";
    }
}
