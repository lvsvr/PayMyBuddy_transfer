package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.TransactionBankToUser;
import com.payMyBuddy.transfert.repository.TransactionBankToUserRepository;
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
