package com.payMyBuddy.transfer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController {

    @RequestMapping("/admin")
    @RolesAllowed("ADMIN")
    public String welcomeAdmin(){
        return "Welcome, admin";
    }

    @RequestMapping("/*")
    @RolesAllowed("USER")
    public String welcomeUser(){
        return "Welcome, user";
    }
}
