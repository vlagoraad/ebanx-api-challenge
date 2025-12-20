package com.ebanx.bankingapi.controller;

import com.ebanx.bankingapi.domain.Account;
import com.ebanx.bankingapi.dto.DepositResponse;
import com.ebanx.bankingapi.dto.EventRequest;
import com.ebanx.bankingapi.dto.TransferResult;
import com.ebanx.bankingapi.dto.WithdrawResponse;
import com.ebanx.bankingapi.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class EventController {
    private final AccountService accountService;

    public EventController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance(@RequestParam("account_id") String accountId){
        BigDecimal balance = accountService.getBalance(accountId);
        if (balance == null){
            return ResponseEntity.status(404).body("0");
        }
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/event")
    public ResponseEntity<?> handleEvent(@RequestBody EventRequest request){
        String type = request.getType();

        if (type.equals("deposit")){
            Account account = accountService.deposit(request.getDestination(), request.getAmount());
            DepositResponse response = new DepositResponse(account);
            return ResponseEntity.status(201).body(response);
        } else if (type.equals("withdraw")){
            Account account = accountService.withdraw(request.getOrigin(), request.getAmount());
            if (account == null) {
                return ResponseEntity.status(404).body("0");
            }
            WithdrawResponse response = new WithdrawResponse(account);
            return ResponseEntity.status(201).body(response);
        } else if (type.equals("transfer")){
            TransferResult result = accountService.transfer(request.getOrigin(), request.getDestination(), request.getAmount());
            if (result == null) {
                return ResponseEntity.status(404).body("0");
            }
            return ResponseEntity.status(201).body(result);
        }
        return null;
    }

}
