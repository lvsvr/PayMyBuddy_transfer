package com.payMyBuddy.transfer.service;


import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;

public interface UserAccountService {

    UserAccount findByUser(User user);

    UserAccount saveUserAccountForUser(User user);

}

