package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.BankAccount;
import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BankAccountServiceTest {

    @Autowired
    private BankAccountService underTest;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @Test
    public void itShouldAddAUserBuddy() {
        //GIVEN
        String email = "user12@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        User user = userService.addUser(userDto);
        String email2 = "user13@spring.omg";
        UserRegistrationDto userDto2 = new UserRegistrationDto(email2, "user", "0", "pwd", "06");
        User buddy = userService.addUser(userDto2);
        UserAccount userAccount = userAccountService.saveUserAccountForUser(user);
        //WHEN
        BankAccount ba = new BankAccount();
        ba.setUserAccount(userAccount);
        ba.setIban("iban");
        //THEN
        assertEquals(underTest.addBankAccount(ba).toString(), ba.toString());
        assertNotNull(underTest.getAllBankAccounts());
        assertNotNull(underTest.getAllBankAccountsByUserAccount(userAccount));
    }
}