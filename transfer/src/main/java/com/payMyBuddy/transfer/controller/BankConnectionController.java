package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.TransferApplication;
import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.BankAccount;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.service.BankAccountService;
import com.payMyBuddy.transfer.service.UserAccountServiceImpl;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankConnectionController {
    private static final Logger logger = LogManager.getLogger(TransferApplication.class);

    private UserServiceImpl userService;
    private UserAccountServiceImpl userAccountService;
    private BankAccountService bankAccountService;

    public BankConnectionController(UserServiceImpl userService, UserAccountServiceImpl userAccountService, BankAccountService bankAccountService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.bankAccountService = bankAccountService;
    }


    @GetMapping("/bankConnection")
    public String findBankConnection(Model model, BankAccount bankAccount) {
        model.addAttribute("bankAccount", new BankAccount());

        logger.info("getTest");
        return "bankConnection";
    }

    @PostMapping("/addConnection")
    public String addBankConnection(@AuthenticationPrincipal AppUser appUser, @ModelAttribute BankAccount bankAccount) {
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        bankAccount.setUserAccount(userAccount);
        logger.info(userAccount);

        bankAccountService.addBankAccount(bankAccount);
        logger.info(bankAccount.getIban());
        return "redirect:/home";
    }
}
