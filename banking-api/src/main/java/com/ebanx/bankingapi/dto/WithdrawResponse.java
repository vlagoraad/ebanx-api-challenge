package com.ebanx.bankingapi.dto;

import com.ebanx.bankingapi.domain.Account;

public class WithdrawResponse {
    private Account origin;

    public WithdrawResponse(Account origin){
        this.origin = origin;
    }

    public Account getOrigin() {
        return origin;
    }
}
