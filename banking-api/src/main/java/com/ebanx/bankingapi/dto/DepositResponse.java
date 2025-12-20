package com.ebanx.bankingapi.dto;

import com.ebanx.bankingapi.domain.Account;

public class DepositResponse {
    private Account destination;

    public DepositResponse(Account destination){
        this.destination = destination;
    }

    public Account getDestination(){
        return destination;
    }
}
