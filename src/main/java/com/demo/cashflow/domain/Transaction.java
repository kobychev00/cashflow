package com.demo.cashflow.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import javax.print.DocFlavor;
import java.util.*;

@Entity
@Table(name = "transactions" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar date;

    @Column(name = "type_id", nullable = false)
    private int typeId;

    @Column(nullable = false)
    private double sum;

    public Transaction(Calendar date, int typeId, double sum) {
        this.date = date;
        this.typeId = typeId;
        this.sum = sum;
    }

    protected Transaction() {
    }

    public Long getId(){
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public int getTypeId() {
        return typeId;
    }

    public double getSum() {
        return sum;
    }

    public abstract String getTransactionType();
}
