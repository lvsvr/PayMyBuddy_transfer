package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;

public interface UserService {

        User findByEmail(String email);
    }
