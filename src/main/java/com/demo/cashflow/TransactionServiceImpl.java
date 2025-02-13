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

        // Получаем тип транзакции из Map types
        String typeName = types.getOrDefault(transaction.getType(), "Unknown");

        // Создаем таблицу с заголовками
        StringBuilder transactionDescription = new StringBuilder();
        transactionDescription.append("<table border='1' style='border-collapse: collapse;'>")
                .append("<tr><th>Date</th><th>Type</th><th>Amount</th><th>Source</th></tr>")
                .append("<tr>")
                .append("<td>").append(formattedDate).append("</td>")
                .append("<td>").append(typeName).append("</td>")
                .append("<td>").append(transaction.getSum()).append("</td>");

        // Проверяем, является ли транзакция доходом (Income) и добавляем источник
        String sourceText = "-"; // Значение по умолчанию
        if (transaction instanceof Income) {
            Income income = (Income) transaction;
            StringBuilder sourcesList = new StringBuilder();

            for (Integer sourceNumber : income.getSourceNumbers()) {
                String sourceName = sources.get(sourceNumber);
                if (sourceName != null) {
                    sourcesList.append(sourceName).append(", ");
                }
            }

            // Убираем лишнюю запятую и пробел
            if (sourcesList.length() > 0) {
                sourcesList.setLength(sourcesList.length() - 2);
                sourceText = sourcesList.toString();
            }
        }

        // Добавляем значение источника в таблицу
        transactionDescription.append("<td>").append(sourceText).append("</td>")
                .append("</tr></table>");

        return transactionDescription.toString();
    }

    @Override
    public String getAllTransactions() {
        // Таблица с заголовками
        StringBuilder transactionDescription = new StringBuilder();
        transactionDescription.append("<table border='1' style='border-collapse: collapse;'>")
                .append("<tr><th>ID</th><th>Date</th><th>Type</th><th>Amount</th><th>Source</th></tr>");

        // Перебор всех транзакций
        for (Map.Entry<String, Transaction> entry : transactions.entrySet()) {
            String id = entry.getKey();
            Transaction transaction = entry.getValue();

            // Форматирование даты
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String formattedDate = sdf.format(transaction.getDate().getTime());

            // Получение типа транзакции
            String typeName = types.getOrDefault(transaction.getType(), "Unknown");

            // Описание источников для типа Income
            String sourceText = "-";
            if (transaction instanceof Income) {
                Income income = (Income) transaction;
                StringBuilder sources = new StringBuilder();

                for (Integer sourceNumber : income.getSourceNumbers()) {
                    String sourceName = this.sources.get(sourceNumber);
                    if (sourceName != null) {
                        sources.append(sourceName).append(", ");
                    }
                }
                if (sources.length() > 0) {
                    sources.setLength(sources.length() - 2); // Убираем лишнюю запятую
                    sourceText = sources.toString();
                }
            }

            // Добавляем информацию о транзакции в таблицу
            transactionDescription.append("<tr>")
                    .append("<td>").append(id).append("</td>")
                    .append("<td>").append(formattedDate).append("</td>")
                    .append("<td>").append(typeName).append("</td>")
                    .append("<td>").append(transaction.getSum()).append("</td>")
                    .append("<td>").append(sourceText).append("</td>")
                    .append("</tr>");
        }

        // Закрытие таблицы
        transactionDescription.append("</table>");
        return transactionDescription.toString();
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
