package com.example.Flat_finder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Flat_finder.entity.User;
import com.example.Flat_finder.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String name, String role, double initialAmount) {
        User user = new User();
        user.setName(name);
        user.setRole(role);
        user.setWalletBalance(initialAmount);
        return userRepository.save(user);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void updateWallet(String userName, double amount) {
        User user = userRepository.findByName(userName).orElseThrow(() -> new RuntimeException("User not found"));
        user.setWalletBalance(user.getWalletBalance() + amount);
        userRepository.save(user);
    }
}
