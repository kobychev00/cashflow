package com.demo.cashflow;

import com.demo.cashflow.domain.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions" )
public class CashflowController {
    private final TransactionService transactionService;

    public CashflowController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("hello" )
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("<b>hello</b>" );
    }

    @GetMapping("/{id}" )
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all" )
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/add" )
    public ResponseEntity<Transaction> addTransation(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.addTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }
}
