package com.ebanx.bankingapi.dto;

import com.ebanx.bankingapi.domain.Account;

public class TransferResult{
    private Account origin;
    private Account destination;

    public TransferResult(Account origin, Account destination){
        this.origin = origin;
        this.destination = destination;
    }

    public Account getOrigin() {
        return origin;
    }

    public Account getDestination() {
        return destination;
    }
}