package com.Bankmanagementapp.AndhraState.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bankmanagementapp.AndhraState.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

