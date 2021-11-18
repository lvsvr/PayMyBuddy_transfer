package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserAccountServiceImplTest {


    @Autowired
    private UserAccountServiceImpl underTest;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void itShouldCreateAnAccountForAGivenUser() {
        //GIVEN
        String email = "user6@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        User user = userService.addUser(userDto);
        //WHEN
        UserAccount userAccount = underTest.saveUserAccountForUser(user);
        //THEN
        assertEquals(user.toString(), userAccount.getUser().toString());
    }

    @Test
    public void itShouldReturnAnAccountByUser() {
        //GIVEN
        String email = "user7@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        User user = userService.addUser(userDto);
        //WHEN
        UserAccount userAccount2 = underTest.saveUserAccountForUser(user);
        //THEN
        assertEquals(underTest.findByUser(user).toString(), userAccount2.toString());
    }
}