package com.shunnior.controllers;

import com.shunnior.models.Account;
import com.shunnior.models.ApiResponse;
import com.shunnior.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Account>> createAccount(@RequestBody Account account) {
        ApiResponse<Account> savedAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(savedAccount, savedAccount.isSuccess()?HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
