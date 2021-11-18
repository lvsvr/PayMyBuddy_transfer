package com.payMyBuddy.transfer.controller;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.service.UserAccountServiceImpl;
import com.payMyBuddy.transfer.service.UserServiceImpl;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private UserAccountServiceImpl userAccountService;

    @Test
    public void itShouldReturnRegistrationForm() throws Exception {
        mockMvc.perform(get("/registration"))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
//    public void shouldInsertUser() throws Exception {
//        String email = "user15@spring.omg";
//        UserRegistrationDto userDto = new UserRegistrationDto(email, "user", "0", "pwd", "06");
//
//        String uri = "/addUser";
//
//        Mockito.when(userAccountService.saveUserAccountForUser(userService.addUser(userDto)));
//
//        assertEquals(outputInJson)
//
//    }
}