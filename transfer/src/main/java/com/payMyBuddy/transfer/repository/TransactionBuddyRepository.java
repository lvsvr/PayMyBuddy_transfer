package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.TransactionBuddy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBuddyRepository extends JpaRepository<TransactionBuddy, Long> {
}
