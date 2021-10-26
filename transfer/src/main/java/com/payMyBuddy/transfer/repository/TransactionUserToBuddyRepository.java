package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.TransactionUserToBuddy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionUserToBuddyRepository extends CrudRepository<TransactionUserToBuddy, Long> {
}
