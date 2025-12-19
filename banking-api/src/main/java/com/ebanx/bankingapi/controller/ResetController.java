package com.ebanx.bankingapi.controller;

import com.ebanx.bankingapi.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetController {
    private final AccountService accountService;

    public ResetController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/reset")
    public String reset(){
        accountService.reset();
        return "OK";
    }
}
