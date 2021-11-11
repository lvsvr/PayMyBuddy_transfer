package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.TransferApplication;
import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.model.UserBuddy;
import com.payMyBuddy.transfer.service.UserAccountService;
import com.payMyBuddy.transfer.service.UserBuddyService;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
public class TransferController {
    private static final Logger logger = LogManager.getLogger(TransferApplication.class);

    private UserServiceImpl userService;
    private UserAccountService userAccountService;
    private UserBuddyService userBuddyService;

    public TransferController(UserServiceImpl userService, UserAccountService userAccountService, UserBuddyService userBuddyService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.userBuddyService = userBuddyService;
    }

    @GetMapping("/transfer")
    public String transfer(Model model, @AuthenticationPrincipal AppUser appUser, User buddy){
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        ArrayList<UserBuddy> userBuddies = userBuddyService.getAllBuddiesByUserAccount(userAccount);
        ArrayList<User> buddies = new ArrayList<User>();
        for (UserBuddy userBuddy: userBuddies){
            buddies.add(userBuddy.getBuddy());
        }
        model.addAttribute("buddies", buddies);
        model.addAttribute("buddy", buddy);
        logger.info("getTest");
        return "transfer";

}
}