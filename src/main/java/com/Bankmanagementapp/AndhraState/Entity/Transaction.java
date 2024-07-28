package com.Bankmanagementapp.AndhraState.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.Bankmanagementapp.AndhraState.Types.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private double amount;
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "accountId")
    @JsonIgnore
    private Account account;

    // Constructors
    public Transaction() {
    }

    public Transaction(TransactionType transactionType, double amount, LocalDateTime transactionDate, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
