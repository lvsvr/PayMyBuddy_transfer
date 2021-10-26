package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.UserBuddy;
import com.payMyBuddy.transfer.repository.UserBuddyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBuddyService {

    private  final UserBuddyRepository userBuddyRepository;

    public UserBuddyService(UserBuddyRepository userBuddyRepository) {
        this.userBuddyRepository = userBuddyRepository;
    }

    public Iterable<UserBuddy> getAllUsers() {
        return userBuddyRepository.findAll();
    }

    public Optional<UserBuddy> getUserBuddyById(Long id) {
        return userBuddyRepository.findById(id);
    }

    public UserBuddy addUserBuddy(UserBuddy userBuddy) {

        return userBuddyRepository.save(userBuddy);
    }

    public void deleteUserBuddy(Long id) {
        userBuddyRepository.deleteById(id);
    }
}
