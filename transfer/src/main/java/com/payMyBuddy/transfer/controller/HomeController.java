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
public class HomeController {

    private ArrayList<User> userList = new ArrayList<>();
    private UserServiceImpl userService;

    public HomeController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
        public String goHome(Model model){
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
