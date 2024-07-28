package com.Bankmanagementapp.AndhraState.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bankmanagementapp.AndhraState.Entity.Account;
import com.Bankmanagementapp.AndhraState.Types.AccountType;
import com.Bankmanagementapp.AndhraState.repo.AccountRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Account createAccount(String username, String fatherName, String mobileNumber, String password, AccountType accountType) {
        Account account = new Account(username, fatherName, mobileNumber, password, accountType, 0.0, LocalDate.now());
        return accountRepository.save(account);
    }

    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public Account updateAccount(Long accountId, String username, String fatherName, String mobileNumber, String password) {
        Account account = getAccount(accountId);
        account.setUsername(username);
        account.setFatherName(fatherName);
        account.setMobileNumber(mobileNumber);
        account.setPassword(password);
        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void applyInterest() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            long years = ChronoUnit.YEARS.between(account.getCreationDate(), LocalDate.now());
            double interestRate = 0.034; // 3.4% annual interest rate
            double newBalance = account.getBalance() * Math.pow((1 + interestRate), years);
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
    }

    @Transactional
    public void updateAccount(Account account) {
        Account existingAccount = getAccount(account.getId());
        existingAccount.setUsername(account.getUsername());
        existingAccount.setFatherName(account.getFatherName());
        existingAccount.setMobileNumber(account.getMobileNumber());
        existingAccount.setPassword(account.getPassword());
        existingAccount.setAccountType(account.getAccountType());
        existingAccount.setBalance(account.getBalance());
        existingAccount.setCreationDate(account.getCreationDate());
        accountRepository.save(existingAccount);
    }
}
