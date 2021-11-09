package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.repository.UserRepository;
import com.payMyBuddy.transfer.web.dto.UserRegistrationDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setPhone(registration.getPhone());
        user.setRole("USER");
        userRepository.save(user);

        return user;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findById(email);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String email) {
        userRepository.deleteById(email);
    }
}


