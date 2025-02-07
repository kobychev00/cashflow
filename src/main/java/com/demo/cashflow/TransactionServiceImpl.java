package com.demo.cashflow;

import com.demo.cashflow.domain.Income;
import com.demo.cashflow.domain.Transaction;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
@Service
public class TransactionServiceImpl implements TransactionService {

    Map<String, Transaction> transactions = new HashMap<>(Map.of(
            "0001", new Income(new GregorianCalendar(2025, Calendar.JANUARY, 25), 1, 15500, 1),
            "0002", new Income(new GregorianCalendar(2025, Calendar.JANUARY, 31), 1, 10000, 3)
    ));

    Map <Integer, String> types = Map.of(
            1, "Income",
            2, "Outcome"
    );

    Map <Integer, String> sources = Map.of(
            1, "Technopark",
            2, "Detvora",
            3, "Digital4Food",
            4, "BKI"
    );

    @Override
    public String getTransactionById(String id) {
        final Transaction transaction = transactions.get(id);
        if (transaction == null) {
            throw new RuntimeException("Транзакция не найдена");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String formattedDate = sdf.format(transaction.getDate().getTime());

        StringBuilder transactionDescription = new StringBuilder();
        transactionDescription.append("<b>Date:</b> ").append(formattedDate).append("<br>")
                .append("<b>Type:</b> ").append(transaction.getType()).append("<br>")
                .append("<b>Amount:</b> ").append(transaction.getSum()).append("<br>");

        // Если транзакция - Income, добавляем значения sourceNumbers из Map source
        if (transaction instanceof Income) {
            Income income = (Income) transaction;
            StringBuilder sources = new StringBuilder();

            for (Integer sourceNumber : income.getSourceNumbers()) {
                String sourceName = this.sources.get(sourceNumber);
                if (sourceName != null) {
                    sources.append(sourceName).append(", ");
                }
            }

            // Убираем лишнюю запятую и пробел в конце
            if (sources.length() > 0) {
                sources.setLength(sources.length() - 2);
                transactionDescription.append("<b>Source:</b> ").append(sources);
            }
        }

        return transactionDescription.toString();
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
