package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.BankAccount;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public ArrayList<BankAccount> getAllBankAccountsByUserAccount(UserAccount userAccount) {
        ArrayList<BankAccount> bankAccounts = getAllBankAccounts();
        ArrayList<BankAccount> bankAccountsByAccount = new ArrayList<BankAccount>();
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getUserAccount().equals(userAccount))
                bankAccountsByAccount.add(bankAccount);
        }
        return bankAccountsByAccount;
    }

    public ArrayList<BankAccount> getAllBankAccounts() {
        return (ArrayList<BankAccount>) bankAccountRepository.findAll();
    }


}
