package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class PmbUserDetailsServiceTest {

    @Autowired
    private PmbUserDetailsService underTest;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void ItShouldReturnNull(){
//        WHEN
        String email = "user14@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        User user = userService.addUser(userDto);
//        THEN
        assertNull(underTest.loadUserByUsername(email));
    }
}