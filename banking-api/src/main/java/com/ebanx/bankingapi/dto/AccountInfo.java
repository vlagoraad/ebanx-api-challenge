package com.ebanx.bankingapi.dto;

import com.ebanx.bankingapi.domain.Account;

import java.math.BigDecimal;

public class AccountInfo {
    private String id;
    private BigDecimal balance;

    public AccountInfo(Account account){
        this.id = account.getId();
        this.balance = account.getBalance();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
