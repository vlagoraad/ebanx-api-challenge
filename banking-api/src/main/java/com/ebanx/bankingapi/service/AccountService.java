package com.ebanx.bankingapi.service;

import org.springframework.stereotype.Service;
import com.ebanx.bankingapi.domain.Account;
import com.ebanx.bankingapi.dto.TransferResult;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

@Service
public class AccountService{
    private Map<String,Account> accounts;

    public AccountService(){
        this.accounts = new HashMap<>();
    }

    public void reset(){
        accounts.clear();
    }

    public BigDecimal getBalance(String accountId){
        Account account = accounts.get(accountId);
        if (account == null) {
            return null;
        }
        return account.getBalance();
    }

    public Account deposit(String accountId, BigDecimal amount){
        Account account = accounts.get(accountId);
        if (account == null) {
            Account a1 = new Account(accountId, amount);
            accounts.put(accountId, a1);
            return a1;
        }
        account.deposit(amount);
        return account;
    }

    public Account withdraw(String accountId, BigDecimal amount){
        Account account = accounts.get(accountId);
        if (account == null){
            return null;
        }
        account.withdraw(amount);
        return account;
    }

    public TransferResult transfer(String originId, String destinationId, BigDecimal amount){
        Account originAccount = withdraw(originId, amount);
        if (originAccount == null){
            return null;
        }
        Account destinationAccount = deposit(destinationId, amount);
        return new TransferResult(originAccount, destinationAccount);
    }
}