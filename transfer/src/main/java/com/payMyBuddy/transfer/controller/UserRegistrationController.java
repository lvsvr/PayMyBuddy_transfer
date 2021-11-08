package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.model.User;
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

    public UserRegistrationController(ArrayList<User> userList, UserServiceImpl userService) {
        this.userList = userList;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(UserRegistrationDto userDto, Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute UserRegistrationDto userDto ){
        userService.save(userDto);

//        userList = (ArrayList<User>) userService.getAllUsers();
//        userDtoList.add(userDto);
        return "redirect:/login";
    }
}

