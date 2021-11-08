//package com.payMyBuddy.transfer.service;
//
//import com.payMyBuddy.transfer.model.User;
//import com.payMyBuddy.transfer.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DbInitService implements CommandLineRunner {
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public DbInitService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User("user@spring.omg", "user", "1", passwordEncoder.encode("user123"), "USER", "06" );
//    this.userRepository.save(user);
//    }
//}
