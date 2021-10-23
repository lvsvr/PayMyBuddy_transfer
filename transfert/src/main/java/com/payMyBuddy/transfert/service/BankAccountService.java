package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.BankAccount;
import com.payMyBuddy.transfert.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public Iterable<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getBankAccountById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
