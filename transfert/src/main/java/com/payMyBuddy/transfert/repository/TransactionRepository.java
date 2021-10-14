package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}

