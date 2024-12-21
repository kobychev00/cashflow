package com.demo.cashflow;

import com.demo.cashflow.domain.Income;
import com.demo.cashflow.domain.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    Map<String, Transaction> transactions = new HashMap<>(Map.of(
            "0001", new Income("Salary", 65000, 1),
            "0002", new Income("Salary", 8000, 2)
    ));

    @Override
    public List<Transaction> getTransactionById(int id) {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
