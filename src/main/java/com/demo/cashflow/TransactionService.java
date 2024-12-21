package com.demo.cashflow;

import com.demo.cashflow.domain.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactionById(int id);

    void addTransaction(Transaction transaction);

}
