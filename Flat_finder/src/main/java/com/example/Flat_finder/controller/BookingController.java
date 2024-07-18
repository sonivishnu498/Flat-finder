package com.example.Flat_finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flat_finder.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/request")
    public ResponseEntity<String> requestBooking(@RequestParam String seekerName, @RequestParam Long flatId) {
        bookingService.requestBooking(seekerName, flatId);
        return ResponseEntity.ok("Booking request sent");
    }

    @PostMapping("/accept")
    public ResponseEntity<String> acceptBooking(@RequestParam String ownerName, @RequestParam Long flatId) {
        bookingService.acceptBooking(ownerName, flatId);
        return ResponseEntity.ok("Booking accepted");
    }
}
