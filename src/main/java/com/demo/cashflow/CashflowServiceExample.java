package com.demo.cashflow;

import org.springframework.stereotype.Service;
@Service
public class CashflowServiceExample {
    public String hello() {
        return "<b>hello</b>";
    }
    public String info(String userName) {
        return "<b>Cashflow info</b> " + userName;
    }
}