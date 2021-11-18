package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBank;
import com.payMyBuddy.transfer.repository.TransactionBankRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionBankService {

    private final TransactionBankRepository transactionBankRepository;

    public TransactionBankService(TransactionBankRepository transactionBankRepository) {
        this.transactionBankRepository = transactionBankRepository;
    }

    public TransactionBank addTransaction(TransactionBank transaction) {

        return transactionBankRepository.save(transaction);
    }

}
