package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.service.UserAccountServiceImpl;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class UserRegistrationController {

    private ArrayList<User> userList = new ArrayList<>();
    private UserServiceImpl userService;
    private UserAccountServiceImpl userAccountService;

    public UserRegistrationController(ArrayList<User> userList, UserServiceImpl userService, UserAccountServiceImpl userAccountService) {
        this.userList = userList;
        this.userService = userService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(UserRegistrationDto userDto, Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute UserRegistrationDto userDto ){
        userAccountService.saveUserAccountForUser(userService.addUser(userDto));
        return "redirect:/login";
    }
}

