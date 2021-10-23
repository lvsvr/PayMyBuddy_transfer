package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.TransactionBankToUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBankToUserRepository extends CrudRepository<TransactionBankToUser, Long> {
}

