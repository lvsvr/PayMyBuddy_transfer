package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBuddy;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.repository.TransactionBuddyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class TransactionBuddyService {
    private final TransactionBuddyRepository transactionBuddyRepository;

    public TransactionBuddyService(TransactionBuddyRepository transactionBuddyRepository) {
        this.transactionBuddyRepository = transactionBuddyRepository;
    }

    public TransactionBuddy addTransaction(TransactionBuddy transaction) {
        return transactionBuddyRepository.save(transaction);
    }

    public Iterable<TransactionBuddy> getAllTransactions() {
        return transactionBuddyRepository.findAll();
    }

    public ArrayList<TransactionBuddy> getAllTransactionsFromUserAccountByUserAccount(UserAccount useraccount) {
        ArrayList<TransactionBuddy> transactionBuddies = (ArrayList<TransactionBuddy>) getAllTransactions();
        ArrayList<TransactionBuddy> transactionsByUserAccount = new ArrayList<>();
        for (TransactionBuddy tb : transactionBuddies) {
            if (tb.getUserBuddy().getUserAccount().equals(useraccount))
                transactionsByUserAccount.add(tb);
        }
        return transactionsByUserAccount;
    }

    public ArrayList<TransactionBuddy> getAllTransactionsFromBuddiesByUserAccount(UserAccount useraccount) {
        ArrayList<TransactionBuddy> transactionBuddies = (ArrayList<TransactionBuddy>) getAllTransactions();
        ArrayList<TransactionBuddy> transactionsFromBuddies = new ArrayList<>();
        for (TransactionBuddy tb : transactionBuddies) {
            if ((tb.getUserBuddy().getBuddy()).equals(useraccount.getUser()))
                transactionsFromBuddies.add(tb);
        }
        return transactionsFromBuddies;
    }

    public ArrayList<TransactionBuddy> getAllTransactionsByUserAccount(UserAccount useraccount){
        ArrayList<TransactionBuddy> transactionsByUserAccount = new ArrayList<>();
        ArrayList<TransactionBuddy> transactionFromUser = getAllTransactionsFromUserAccountByUserAccount(useraccount);
        ArrayList<TransactionBuddy> transactionFromBuddies = getAllTransactionsFromBuddiesByUserAccount(useraccount);
        for(TransactionBuddy tb : transactionFromUser) {
            transactionsByUserAccount.add(tb);
        }
        for(TransactionBuddy tb : transactionFromBuddies) {
            transactionsByUserAccount.add(tb);
        }
        transactionsByUserAccount.sort(Comparator.comparing(TransactionBuddy::getDate));
            return transactionsByUserAccount;
        }
    }

