package com.demo.cashflow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashflowController {
    private final CashflowServiceExample cashflowServiceExample;

    public CashflowController(CashflowServiceExample cashflowServiceExample) {
        this.cashflowServiceExample = cashflowServiceExample;
    }

    @RequestMapping
    public String hello() {
        return cashflowServiceExample.hello();
    }

    @RequestMapping(path = "/info")
    public String info(@RequestParam("name") String userName) {
        return cashflowServiceExample.info(userName);
    }
}
