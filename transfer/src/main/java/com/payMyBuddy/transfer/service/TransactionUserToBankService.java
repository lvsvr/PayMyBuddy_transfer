package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionUserToBank;
import com.payMyBuddy.transfer.repository.TransactionUserToBankRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionUserToBankService {

    private final TransactionUserToBankRepository transactionUserToBankRepository;

    public TransactionUserToBankService(TransactionUserToBankRepository transactionUserToBankRepository) {
        this.transactionUserToBankRepository = transactionUserToBankRepository;
    }


    public Iterable<TransactionUserToBank> getAllTransactions() {
        return transactionUserToBankRepository.findAll();
    }

    public Optional<TransactionUserToBank> getTransactionById(Long id) {
        return transactionUserToBankRepository.findById(id);
    }

    public TransactionUserToBank addTransaction(TransactionUserToBank transaction){
        return transactionUserToBankRepository.save(transaction);
    }

    public void deleteTransactionById(Long id){
        transactionUserToBankRepository.deleteById(id);
    }

}
