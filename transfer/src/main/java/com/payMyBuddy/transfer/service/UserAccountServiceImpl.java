package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.repository.UserAccountRepository;
import com.payMyBuddy.transfer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount findByUser(User user) {
        UserAccount userAccount = userAccountRepository.findByUser(user);
        return userAccount;
    }

    @Override
    public UserAccount saveUserAccountForUser(User user) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        userAccount.setBalance(1000);
        userAccountRepository.save(userAccount);
        return userAccount;
    }




    public Iterable<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> getUserAccountById(Long id) {
        return userAccountRepository.findById(id);
    }

    public UserAccount addUserAccount(UserAccount userAccount) {

        return userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }


}
