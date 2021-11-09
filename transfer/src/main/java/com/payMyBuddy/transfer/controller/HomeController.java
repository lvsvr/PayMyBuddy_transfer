package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.service.UserAccountService;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    private ArrayList<User> userList = new ArrayList<>();
    private UserServiceImpl userService;
    private UserAccountService userAccountService;

    public HomeController(UserServiceImpl userService, UserAccountService userAccountService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/home")
        public String goHome(@AuthenticationPrincipal AppUser appUser,Model model){
        String email = appUser.getUsername();
        UserAccount userAccount = userAccountService.findByUser(userService.findByEmail(email));
        model.addAttribute("balance", userAccount.getBalance());
        model.addAttribute("userList", userList);
        userList = (ArrayList<User>) userService.getAllUsers();
        return "home";
        }
//    @GetMapping("/registration")
//    public String getRegistrationForm(UserRegistrationDto userDto, Model model) {
//        model.addAttribute("userDto", new UserRegistrationDto());
//        return "registration2";
//    }
//
//    @PostMapping("/addUser")
//    public String addUser(@ModelAttribute UserRegistrationDto userDto ){
//        userService.save(userDto);
//        userList = (ArrayList<User>) userService.getAllUsers();
////        userDtoList.add(userDto);
//        return "redirect:/home";
//    }


}
