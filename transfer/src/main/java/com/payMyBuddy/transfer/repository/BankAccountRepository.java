package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
