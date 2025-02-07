package com.demo.cashflow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashflowController {
    private final TransactionService transactionService;

    public CashflowController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping (path = "/hello")
    public String hello() {
        return "<b>hello</b>";
    }

    //
    @RequestMapping(path = "/info")
    public String info(@RequestParam("name") String userName) {
        return "<b>Cashflow info</b> " + userName;
    }

    @RequestMapping(path = "/transactions/id")
    public String getTransaction(@RequestParam("number") String id) {
        String header1 = "<b>Search transaction by ID</b><br>";
        String header2 = "<br><b>Result:</b><br>";
        String result = "<br>" + transactionService.getTransactionById(id);

        return header1 + header2 + result;
    }
}
