package com.example.Flat_finder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flat_finder.entity.Flat;
import com.example.Flat_finder.entity.User;
import com.example.Flat_finder.service.FlatService;
import com.example.Flat_finder.service.UserService;

@RestController
@RequestMapping("/flats")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private UserService userService;

    @PostMapping("/post")
    public ResponseEntity<Flat> postFlat(@RequestParam String ownerName, @RequestParam String location, @RequestParam double rent, @RequestParam int rooms) {
        User owner = userService.getUserByName(ownerName).orElseThrow(() -> new RuntimeException("Owner not found"));
        Flat flat = flatService.postFlat(owner, location, rent, rooms);
        return ResponseEntity.ok(flat);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Flat>> getAllAvailableFlats() {
        List<Flat> flats = flatService.getAllAvailableFlats();
        return ResponseEntity.ok(flats);
    }
}
