package com.ebanx.bankingapi.controller;

import com.ebanx.bankingapi.service.AccountService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private final AccountService accountService;

    public EventController(AccountService accountService){
        this.accountService = accountService;
    }


}
