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
//        User mockUser = new User(0,"user", "user", "a", passwordEncoder.encode("password"), "USER", "06" );
//        User user = new User(0,"user@test.omg", "user", "a", passwordEncoder.encode("123"), "USER", "06" );
//    this.userRepository.save(user);
//    }
//}
