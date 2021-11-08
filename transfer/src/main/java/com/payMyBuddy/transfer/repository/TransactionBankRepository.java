package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.TransactionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBankRepository extends JpaRepository<TransactionBank, Long> {
}

