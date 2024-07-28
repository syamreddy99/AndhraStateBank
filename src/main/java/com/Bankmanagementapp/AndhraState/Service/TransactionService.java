package com.Bankmanagementapp.AndhraState.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bankmanagementapp.AndhraState.Entity.Account;
import com.Bankmanagementapp.AndhraState.Entity.Transaction;
import com.Bankmanagementapp.AndhraState.Types.TransactionType;
import com.Bankmanagementapp.AndhraState.repo.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Transactional
    public Transaction createTransaction(Long accountId, TransactionType transactionType, double amount) {
        Account account = accountService.getAccount(accountId);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAccount(account);

        if (transactionType == TransactionType.DEPOSIT) {
            account.setBalance(account.getBalance() + amount);
        } else if (transactionType == TransactionType.WITHDRAWAL) {
            if (account.getBalance() < amount) {
                throw new RuntimeException("Insufficient funds");
            }
            account.setBalance(account.getBalance() - amount);
        }

        accountService.updateAccount(account); // Save the updated account

        return transactionRepository.save(transaction);
    }

    public Transaction getTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
