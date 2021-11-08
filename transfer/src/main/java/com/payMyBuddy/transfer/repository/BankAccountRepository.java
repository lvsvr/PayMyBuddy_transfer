package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
