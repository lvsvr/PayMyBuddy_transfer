package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.BankAccount;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public ArrayList<String> getIbanListByUserAccount(UserAccount userAccount){
        ArrayList<BankAccount> bankAccounts = getAllBankAccounts();
        ArrayList<String> ibans = new ArrayList<String>();
        for(BankAccount bankAccount : bankAccounts ){
            if (bankAccount.getUserAccount() == userAccount)
                ibans.add(bankAccount.getIban());
        }
        return ibans;
    }

    public ArrayList<BankAccount> getAllBankAccounts() {
        return (ArrayList<BankAccount>) bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getBankAccountById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
