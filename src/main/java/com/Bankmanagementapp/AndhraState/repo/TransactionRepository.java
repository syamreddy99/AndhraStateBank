package com.Bankmanagementapp.AndhraState.repo;

import com.Bankmanagementapp.AndhraState.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
