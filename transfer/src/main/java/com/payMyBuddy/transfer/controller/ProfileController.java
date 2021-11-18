package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.TransferApplication;
import com.payMyBuddy.transfer.auth.AppUser;
import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private static final Logger logger = LogManager.getLogger(TransferApplication.class);
    private UserServiceImpl userService;

    public ProfileController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal AppUser appUser, Model model, @ModelAttribute User user) {
        user = userService.findByEmail(appUser.getUsername());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/updateProfile")
    @PreAuthorize("hasRole(USER)")
    public String updateUser(@AuthenticationPrincipal AppUser appUser, @ModelAttribute User updatedUser) {
        logger.info("user before update: " + userService.findByEmail(appUser.getUsername()));
        logger.info("update:" + updatedUser);
        User user = userService.findByEmail(appUser.getUsername());
        userService.updateUserByCloningUpdatedUser(user, updatedUser);
        logger.info("user has been updated: " + user);
        return "redirect:/login";
    }

}
