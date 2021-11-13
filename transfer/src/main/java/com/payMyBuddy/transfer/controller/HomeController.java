package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.TransferApplication;
import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.*;
import com.payMyBuddy.transfer.service.BankAccountService;
import com.payMyBuddy.transfer.service.TransactionBankService;
import com.payMyBuddy.transfer.service.UserAccountService;
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
import java.util.Date;

@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(TransferApplication.class);


    private UserServiceImpl userService;
    private UserAccountService userAccountService;
    private BankAccountService bankAccountService;
    private TransactionBankService transactionBankService;

    public HomeController(UserServiceImpl userService, UserAccountService userAccountService, BankAccountService bankAccountService, TransactionBankService transactionBankService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.bankAccountService = bankAccountService;
        this.transactionBankService = transactionBankService;
    }

    @GetMapping("/home")
    public String goHome(@AuthenticationPrincipal AppUser appUser,Model model, BankAccount bankAccount, TransactionBank transactionBank){
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        model.addAttribute("balance", userAccount.getBalance());
        ArrayList<BankAccount> bankAccounts = bankAccountService.getAllBankAccountsByUserAccount(userAccount);
        model.addAttribute("transactionBank", transactionBank);
        model.addAttribute("bankAccounts", bankAccounts);
        model.addAttribute("bankAccount", bankAccount);
        return "home";
    }

       @PostMapping("/addBankTransfer")
        public String createBankTransfer(@AuthenticationPrincipal AppUser appUser, Model model, @ModelAttribute BankAccount bankAccount, @ModelAttribute TransactionBank transactionBank){
//           model.addAttribute("bankAccount", bankAccount);
//           model.addAttribute("amount", transactionBank.getAmount());
           logger.info(transactionBank.getAmount());
           logger.info(transactionBank.getBankAccount().getIban());
           String email = appUser.getUsername();
           UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
           ArrayList<BankAccount> bankAccounts = bankAccountService.getAllBankAccountsByUserAccount(userAccount);
           for(BankAccount ba : bankAccounts){
               if(ba.getIban().equals(transactionBank.getBankAccount().getIban()))
                   transactionBank.setBankAccount(ba);
           }
           logger.info(transactionBank.getBankAccount().getUserAccount());
           Date date = new Date();
           transactionBank.setDate(date);
           transactionBank.setFromBank(false);
           userAccount.setBalance(userAccount.getBalance() - transactionBank.getAmount());
           TransactionBank savedTransactionBank = transactionBankService.addTransaction(transactionBank);
           logger.info(transactionBank);
        return "redirect:/home";
       }
}
