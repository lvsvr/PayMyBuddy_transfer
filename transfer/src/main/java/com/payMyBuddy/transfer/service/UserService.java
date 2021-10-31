package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.repository.UserRepository;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserRegistrationDto registrationDto){
        User user = new User(registrationDto.getEmail(), registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getPassword(), "ROLE_USER", registrationDto.getPhone(), registrationDto.getBirthDate());
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String email) {
        return userRepository.findById(email);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String email){
        userRepository.deleteById(email);
    }
}
