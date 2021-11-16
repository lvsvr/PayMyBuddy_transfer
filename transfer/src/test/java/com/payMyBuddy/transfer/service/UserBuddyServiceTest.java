package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.model.UserBuddy;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserBuddyServiceTest {

    @Autowired
    private UserBuddyService underTest;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserAccountService userAccountService;

    @Test
    public void itShouldAddAUserBuddy() {
        //GIVEN
        String email = "user8@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        User user = userService.addUser(userDto);
        String email2 = "user9@spring.omg";
        UserRegistrationDto userDto2 = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        User buddy = userService.addUser(userDto);
        UserAccount userAccount = userAccountService.saveUserAccountForUser(user);
        //WHEN
        UserBuddy userBuddy = new UserBuddy(userAccount, buddy);
        //THEN
        assertEquals(underTest.addUserBuddy(userBuddy).toString(), userBuddy.toString());
    }
}