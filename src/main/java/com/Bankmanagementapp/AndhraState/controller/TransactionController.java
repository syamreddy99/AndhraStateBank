package com.Bankmanagementapp.AndhraState.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Bankmanagementapp.AndhraState.Entity.Transaction;
import com.Bankmanagementapp.AndhraState.Service.TransactionService;
import com.Bankmanagementapp.AndhraState.Types.TransactionType;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public Transaction createTransaction(@RequestParam Long accountId, @RequestParam TransactionType transactionType, @RequestParam double amount) {
        return transactionService.createTransaction(accountId, transactionType, amount);
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransaction(@PathVariable Long transactionId) {
        return transactionService.getTransaction(transactionId);
    }

    @DeleteMapping("/{transactionId}")
    public void deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
