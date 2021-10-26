package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBankToUser;
import com.payMyBuddy.transfer.repository.TransactionBankToUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionBankToUserService {

    private final TransactionBankToUserRepository transactionBankToUserRepository;

    public TransactionBankToUserService(TransactionBankToUserRepository transactionBankToUserRepository) {
        this.transactionBankToUserRepository = transactionBankToUserRepository;
    }

    public Iterable<TransactionBankToUser> getAllTransactions(){
        return transactionBankToUserRepository.findAll();
    }

    public Optional<TransactionBankToUser> getTransactionById(Long id){
        return transactionBankToUserRepository.findById(id);
    }

    public TransactionBankToUser addTransaction(TransactionBankToUser transaction){

        return transactionBankToUserRepository.save(transaction);
    }

    public void deleteTransactionById(Long id){
        transactionBankToUserRepository.deleteById(id);
    }
}
