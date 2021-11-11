package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.TransferApplication;
import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.model.UserBuddy;
import com.payMyBuddy.transfer.service.UserAccountServiceImpl;
import com.payMyBuddy.transfer.service.UserBuddyService;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ConnectionController {
    private static final Logger logger = LogManager.getLogger(TransferApplication.class);

    @ModelAttribute("allUsers")
    public ArrayList<User> returnUsers(){
        return (ArrayList<User>) userService.getAllUsers();
    }

    private UserServiceImpl userService;
    private UserAccountServiceImpl userAccountService;
    private UserBuddyService userBuddyService;

    public ConnectionController(UserServiceImpl userService, UserAccountServiceImpl userAccountService, UserBuddyService userBuddyService) {
        this.userService = userService;
        this.userAccountService = userAccountService;

        this.userBuddyService = userBuddyService;
    }

    @GetMapping("/connection")
    public String findConnection(@ModelAttribute("allUsers")ArrayList<User>userList, Model model, User user){
        model.addAttribute("userList", userList);
        model.addAttribute("user", new User());
        logger.info("getTest");
        return "connection";
    }

    @PostMapping("/connection")
    public String addConnection(@ModelAttribute User user, @AuthenticationPrincipal AppUser appUser) {
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        UserBuddy userBuddy = new UserBuddy();
        userBuddy.setUserAccount(userAccount);
        userBuddy.setBuddy(userService.findByEmail(user.getEmail()));
        logger.info("userName: " + email + " - buddy: " + user.getEmail());
        userBuddyService.addUserBuddy(userBuddy);
        return "redirect:/transfer";
    }
}
