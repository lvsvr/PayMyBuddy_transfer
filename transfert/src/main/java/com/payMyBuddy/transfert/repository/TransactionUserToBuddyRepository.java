package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.TransactionUserToBuddy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionUserToBuddyRepository extends CrudRepository<TransactionUserToBuddy, Long> {
}
