package com.example.Flat_finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flat_finder.entity.User;
import com.example.Flat_finder.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestParam String name, @RequestParam String role, @RequestParam double initialAmount) {
        User user = userService.registerUser(name, role, initialAmount);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/update-wallet")
    public ResponseEntity<String> updateWallet(@RequestParam String userName, @RequestParam double amount) {
        userService.updateWallet(userName, amount);
        return ResponseEntity.ok("Wallet updated successfully");
    }
}
