package com.demo.cashflow;

import com.demo.cashflow.domain.Income;
import com.demo.cashflow.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
@Service
public class TransactionServiceImpl implements TransactionService {

    Map<String, Transaction> transactions = new HashMap<>(Map.of(
            "0001", new Income(new GregorianCalendar(2025, Calendar.JANUARY, 25), "Technopark", 15500, 1),
            "0002", new Income(new GregorianCalendar(2025, Calendar.JANUARY, 31), "Digital4Food", 10000, 3)
    ));



    @Override
    public String getTransactionById(String id) {
        final Transaction transaction = transactions.get(id);
        if (transaction == null) {
            throw new RuntimeException("Транзакция не найдена");
        }
        final String transactionDiscription = " "
                + transaction.getDate() + " "
                + transaction.getName() + " "
                + transaction.getSum() + " ";
        return transactionDiscription;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
