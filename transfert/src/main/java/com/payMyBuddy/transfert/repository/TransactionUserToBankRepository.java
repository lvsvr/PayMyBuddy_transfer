package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.TransactionUserToBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionUserToBankRepository extends CrudRepository<TransactionUserToBank, Long> {

}
