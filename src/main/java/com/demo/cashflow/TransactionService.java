package com.demo.cashflow;

import com.demo.cashflow.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    String getTransactionById(String id);

    void addTransaction(Transaction transaction);

}
