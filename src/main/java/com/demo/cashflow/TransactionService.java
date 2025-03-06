package com.demo.cashflow;

import com.demo.cashflow.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionService {

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionById(String Id);

    Transaction saveTransaction(Transaction transaction);

    Transaction addTransaction(Transaction transaction);
}
