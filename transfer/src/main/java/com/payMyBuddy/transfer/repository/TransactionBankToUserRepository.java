package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.TransactionBankToUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBankToUserRepository extends CrudRepository<TransactionBankToUser, Long> {
}

