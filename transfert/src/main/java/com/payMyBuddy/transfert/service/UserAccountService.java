package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.UserAccount;
import com.payMyBuddy.transfert.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public Iterable<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> getUserAccountById(Long id){
        return userAccountRepository.findById(id);
    }

    public void saveUserAccount(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(Long id){
        userAccountRepository.deleteById(id);
    }

}
