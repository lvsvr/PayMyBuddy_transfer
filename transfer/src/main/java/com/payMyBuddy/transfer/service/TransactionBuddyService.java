package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBuddy;
import com.payMyBuddy.transfer.repository.TransactionBuddyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionBuddyService {
    private final TransactionBuddyRepository transactionBuddyRepository;

    public TransactionBuddyService(TransactionBuddyRepository transactionBuddyRepository) {
        this.transactionBuddyRepository = transactionBuddyRepository;
    }

    public Iterable<TransactionBuddy> getAllTransactions() {
        return transactionBuddyRepository.findAll();
    }

    public Optional<TransactionBuddy> getTransactionById(Long id){
        return transactionBuddyRepository.findById(id);
    }

    public TransactionBuddy addTransaction(TransactionBuddy transaction){
        return transactionBuddyRepository.save(transaction);
    }

    public void deleteTransactionById(Long id){
        transactionBuddyRepository.deleteById(id);
    }
}
