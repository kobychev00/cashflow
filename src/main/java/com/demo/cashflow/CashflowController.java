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

    @RequestMapping(path = "/info")
    public String info(@RequestParam("name") String userName) {
        return "<b>Cashflow info</b> " + userName;
    }

    @RequestMapping(path = "/transactions/id")
    public String id (@RequestParam("number") String id){
        return transactionService.getTransactionById(id);
    }
}
