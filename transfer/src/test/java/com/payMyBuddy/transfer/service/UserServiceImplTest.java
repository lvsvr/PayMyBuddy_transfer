package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl underTest;

    @Test
    public void itShouldReturnAUserByEmail(){
        //GIVEN
        String email = "user@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        //WHEN
        User user = underTest.addUser(userDto);
        //THEN
        assertEquals(underTest.findByEmail(email).toString(), user.toString().toString());
    }

    @Test
    public void itShouldUpdateUserByCloningUpdateUser(){
        //GIVEN
        String email = "user2@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        String email2 = "user3@spring.omg";
        User user2= new User();
        user2.setEmail(email2);
        user2.setFirstName("u");
        user2.setFirstName("2");
        user2.setPassword("123");
        //WHEN
        User user = underTest.addUser(userDto);
        underTest.updateUserByCloningUpdatedUser(user, user2);
        //THEN
        assertEquals(user.getEmail(), user2.getEmail());
    }

    @Test
    public void itShouldReturnAListOfAllUsers(){
        //GIVEN
        String email = "user4@spring.omg";
        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
        String email2 = "user5@spring.omg";
        UserRegistrationDto userDto2 = new UserRegistrationDto(email2, "u", "2", "pwd", "06");
        //WHEN
        User user = underTest.addUser(userDto);
        User user2 = underTest.addUser(userDto2);
        ArrayList<User> userList1 = new ArrayList<User>();
        userList1.add(user);
        userList1.add(user2);
        ArrayList<User> userList2 = (ArrayList<User>) underTest.getAllUsers();
        //THEN
        assertNotNull(userList2);

    }

}