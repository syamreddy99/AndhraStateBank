package com.Bankmanagementapp.AndhraState.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import com.Bankmanagementapp.AndhraState.Types.AccountType;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String fatherName;
    private String mobileNumber;
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double balance;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    // Constructors
    public Account() {
    }

    public Account(String username, String fatherName, String mobileNumber, String password, AccountType accountType, double balance, LocalDate creationDate) {
        this.username = username;
        this.fatherName = fatherName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.accountType = accountType;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
