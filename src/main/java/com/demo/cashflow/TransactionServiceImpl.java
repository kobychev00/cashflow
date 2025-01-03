package com.demo.cashflow;

import com.demo.cashflow.domain.Income;
import com.demo.cashflow.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TransactionServiceImpl implements TransactionService {

    Map<String, Transaction> transactions = new HashMap<>(Map.of(
            "0001", new Income("1", "Salary", 65000, 1),
            "0002", new Income("2", "Salary", 8000, 2)
    ));

    @Override
    public String getTransactionById(String id) {
        final Transaction transaction = transactions.get(id);
        if (transaction == null) {
            throw new RuntimeException("Транзакция не найдена");
        }
        final String transactionDiscription = " "
                + transaction.getId() + " "
                + transaction.getName() + " "
                + transaction.getSum() + " ";
        return transactionDiscription;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
