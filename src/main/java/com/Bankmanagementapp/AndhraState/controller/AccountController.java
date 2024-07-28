package com.Bankmanagementapp.AndhraState.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Bankmanagementapp.AndhraState.Entity.Account;
import com.Bankmanagementapp.AndhraState.Service.AccountService;
import com.Bankmanagementapp.AndhraState.Types.AccountType;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    //http://localhost:9976/api/accounts
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(
                account.getUsername(),
                account.getFatherName(),
                account.getMobileNumber(),
                account.getPassword(),
                account.getAccountType()
        );
    }
   // http://localhost:9976/api/accounts/1
    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }
   // http://localhost:9976/api/accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
    // http://localhost:9976/api/accounts
    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }
    //http://localhost:9976/api/accounts/1
    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        return accountService.updateAccount(
                accountId,
                account.getUsername(),
                account.getFatherName(),
                account.getMobileNumber(),
                account.getPassword()
        );
    }
    //http://localhost:9976/api/accounts/applyInterest
    @PostMapping("/applyInterest")
    public void applyInterest() {
        accountService.applyInterest();
    }
}
