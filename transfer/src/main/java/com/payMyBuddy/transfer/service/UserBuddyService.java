package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.model.UserBuddy;
import com.payMyBuddy.transfer.repository.UserBuddyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserBuddyService {

    private final UserBuddyRepository userBuddyRepository;

    public UserBuddyService(UserBuddyRepository userBuddyRepository) {
        this.userBuddyRepository = userBuddyRepository;
    }


    public UserBuddy addUserBuddy(UserBuddy userBuddy) {

        return userBuddyRepository.save(userBuddy);
    }

    public ArrayList<UserBuddy> getAllUserBuddies() {
        return (ArrayList<UserBuddy>) userBuddyRepository.findAll();
    }
    
    public ArrayList<UserBuddy> getAllBuddiesByUserAccount(UserAccount userAccount) {
        ArrayList<UserBuddy> userBuddies = getAllUserBuddies();
        ArrayList<UserBuddy> userBuddiesByAccount = new ArrayList<UserBuddy>();
        for (UserBuddy userBuddy : userBuddies) {
            if (userBuddy.getUserAccount().equals(userAccount))
                userBuddiesByAccount.add(userBuddy);
        }
        return userBuddiesByAccount;
    }


}
