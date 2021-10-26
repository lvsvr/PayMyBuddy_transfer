package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public Iterable<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> getUserAccountById(Long id){
        return userAccountRepository.findById(id);
    }

    public UserAccount addUserAccount(UserAccount userAccount){

        return userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(Long id){
        userAccountRepository.deleteById(id);
    }

}
