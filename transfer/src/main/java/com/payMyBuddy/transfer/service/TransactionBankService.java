package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBank;
import com.payMyBuddy.transfer.repository.TransactionBankRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionBankService {

    private final TransactionBankRepository transactionBankRepository;

    public TransactionBankService(TransactionBankRepository transactionBankRepository) {
        this.transactionBankRepository = transactionBankRepository;
    }

    public Iterable<TransactionBank> getAllTransactions(){
        return transactionBankRepository.findAll();
    }

    public Optional<TransactionBank> getTransactionById(Long id){
        return transactionBankRepository.findById(id);
    }

    public TransactionBank addTransaction(TransactionBank transaction){

        return transactionBankRepository.save(transaction);
    }

    public void deleteTransactionById(Long id){
        transactionBankRepository.deleteById(id);
    }
}
