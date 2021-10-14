package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
