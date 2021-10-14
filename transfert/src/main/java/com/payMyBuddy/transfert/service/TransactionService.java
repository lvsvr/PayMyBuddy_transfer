package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.Transaction;
import com.payMyBuddy.transfert.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Iterable<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public void saveTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    public void deleteTransactionById(Long id){
        transactionRepository.deleteById(id);
    }
}
