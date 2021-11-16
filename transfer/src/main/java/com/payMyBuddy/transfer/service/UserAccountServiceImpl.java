package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount saveUserAccountForUser(User user) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        userAccount.setBalance(1000);
        userAccountRepository.save(userAccount);
        return userAccount;
    }

    @Override
    public UserAccount findByUser(User user) {
        UserAccount userAccount = userAccountRepository.findByUser(user);
        return userAccount;
    }

}
