package com.ebanx.bankingapi.domain;

import java.math.BigDecimal;

public class Account {
    private String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal balance){
        this.id = id;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount){
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        balance = balance.subtract(amount);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance(){
        return balance;
    }
}