package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.TransferApplication;
import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.TransactionBuddy;
import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.model.UserBuddy;
import com.payMyBuddy.transfer.service.TransactionBuddyService;
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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

@Controller
public class TransferController {
    private static final Logger logger = LogManager.getLogger(TransferApplication.class);

    private UserServiceImpl userService;
    private UserAccountService userAccountService;
    private UserBuddyService userBuddyService;
    private TransactionBuddyService transactionBuddyService;

    public TransferController(UserServiceImpl userService, UserAccountService userAccountService, UserBuddyService userBuddyService, TransactionBuddyService transactionBuddyService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.userBuddyService = userBuddyService;
        this.transactionBuddyService = transactionBuddyService;
    }

    @GetMapping("/transfer")
    public String getTransferPage(Model model, @AuthenticationPrincipal AppUser appUser, User buddy, TransactionBuddy transactionBuddy) {
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        ArrayList<UserBuddy> userBuddies = userBuddyService.getAllBuddiesByUserAccount(userAccount);
        ArrayList<User> buddies = new ArrayList<User>();
        for (UserBuddy userBuddy : userBuddies) {
            buddies.add(userBuddy.getBuddy());
        }
        model.addAttribute("transactionBuddy", transactionBuddy);
        model.addAttribute("buddies", buddies);
        model.addAttribute("buddy", buddy);
        ArrayList<TransactionBuddy> transactionBuddies = (ArrayList<TransactionBuddy>) transactionBuddyService.getAllTransactions();
        Collections collection = null;
        collection.reverse(transactionBuddies);
        model.addAttribute("transactionBuddies", transactionBuddies);
        logger.info("getTest");
        return "transfer";

    }

    @PostMapping("/addTransfer")
    public String createTransfer(@AuthenticationPrincipal AppUser appUser, Model model, @ModelAttribute User buddy, @ModelAttribute TransactionBuddy transactionBuddy) {
        model.addAttribute("transactionBuddy", transactionBuddy);
        model.addAttribute("amount", transactionBuddy.getAmount());
        model.addAttribute("description", transactionBuddy.getDescription());
        logger.info(transactionBuddy.getAmount());
        logger.info(transactionBuddy.getUserBuddy().getBuddy().getEmail());
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        ArrayList<UserBuddy> userBuddies = userBuddyService.getAllBuddiesByUserAccount(userAccount);
        for(UserBuddy userBuddy : userBuddies){
            if(userBuddy.getBuddy().getEmail().equals(transactionBuddy.getUserBuddy().getBuddy().getEmail()))
                transactionBuddy.setUserBuddy(userBuddy);
        }
        Date date = new Date();
        transactionBuddy.setDate(date);
        transactionBuddy.setFromUser(true);
        userAccount.setBalance(userAccount.getBalance() - transactionBuddy.getAmount() - (0.005*transactionBuddy.getAmount()));
        userAccountService.findByUser(transactionBuddy.getUserBuddy().getBuddy()).setBalance(userAccountService.findByUser(transactionBuddy.getUserBuddy().getBuddy()).getBalance() + transactionBuddy.getAmount());
        TransactionBuddy savedTransactionBuddy = transactionBuddyService.addTransaction(transactionBuddy);
        logger.info(transactionBuddy);
        return "redirect:/transfer";
    }
}