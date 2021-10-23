package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.TransactionUserToBuddy;
import com.payMyBuddy.transfert.repository.TransactionUserToBuddyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionUserToBuddyService {
    private final TransactionUserToBuddyRepository transactionUserToBuddyRepository;

    public TransactionUserToBuddyService(TransactionUserToBuddyRepository transactionUserToBuddyRepository) {
        this.transactionUserToBuddyRepository = transactionUserToBuddyRepository;
    }

    public Iterable<TransactionUserToBuddy> getAllTransactions() {
        return transactionUserToBuddyRepository.findAll();
    }

    public Optional<TransactionUserToBuddy> getTransactionById(Long id){
        return transactionUserToBuddyRepository.findById(id);
    }

    public TransactionUserToBuddy addTransaction(TransactionUserToBuddy transaction){
        return transactionUserToBuddyRepository.save(transaction);
    }

    public void deleteTransactionById(Long id){
        transactionUserToBuddyRepository.deleteById(id);
    }
}
