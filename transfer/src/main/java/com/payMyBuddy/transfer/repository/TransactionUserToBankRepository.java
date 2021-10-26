package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.TransactionUserToBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionUserToBankRepository extends CrudRepository<TransactionUserToBank, Long> {

}
