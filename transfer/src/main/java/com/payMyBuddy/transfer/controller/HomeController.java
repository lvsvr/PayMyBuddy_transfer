package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.BankAccount;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.service.BankAccountService;
import com.payMyBuddy.transfer.service.UserAccountService;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    private UserServiceImpl userService;
    private UserAccountService userAccountService;
    private BankAccountService bankAccountService;

    public HomeController(UserServiceImpl userService, UserAccountService userAccountService, BankAccountService bankAccountService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/home")
        public String goHome(@AuthenticationPrincipal AppUser appUser,Model model, String iban){
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        model.addAttribute("balance", userAccount.getBalance());
        ArrayList<String> ibans = bankAccountService.getIbanListByUserAccount(userAccount);
        model.addAttribute("ibans", ibans);
        model.addAttribute("iban", iban);
        return "home";
        }
}
