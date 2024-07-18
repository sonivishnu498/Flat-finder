package com.example.Flat_finder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Flat_finder.entity.Flat;
import com.example.Flat_finder.entity.User;
import com.example.Flat_finder.repo.FlatRepository;
import com.example.Flat_finder.repo.UserRepository;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlatRepository flatRepository;

    private double companyWallet = 0.0;

    public void requestBooking(String seekerName, Long flatId) {
        User seeker = userRepository.findByName(seekerName).orElseThrow(() -> new RuntimeException("User not found"));
        Flat flat = flatRepository.findById(flatId).orElseThrow(() -> new RuntimeException("Flat not found"));

        if (seeker.getRole().equals("seeker") && flat.getStatus().equals("available")) {
            if (seeker.getWalletBalance() >= flat.getRent()) {
                flat.setStatus("pending");
                flatRepository.save(flat);
            } else {
                throw new RuntimeException("Insufficient Balance in Wallet");
            }
        } else {
            throw new RuntimeException("Invalid seeker or flat not available");
        }
    }

    public void acceptBooking(String ownerName, Long flatId) {
        Flat flat = flatRepository.findById(flatId).orElseThrow(() -> new RuntimeException("Flat not found"));
        User owner = userRepository.findByName(ownerName).orElseThrow(() -> new RuntimeException("Owner not found"));

        if (flat.getOwner().equals(owner) && flat.getStatus().equals("pending")) {
            User seeker = flat.getOwner();
            double brokerage = flat.getRent() * 0.1;
            double ownerAmount = flat.getRent() - brokerage;

            seeker.setWalletBalance(seeker.getWalletBalance() - flat.getRent());
            owner.setWalletBalance(owner.getWalletBalance() + ownerAmount);
            companyWallet += brokerage;

            flat.setStatus("booked");
            flatRepository.save(flat);
            userRepository.save(seeker);
            userRepository.save(owner);
        } else {
            throw new RuntimeException("Invalid owner or booking not pending");
        }
    }

    public double getCompanyWalletBalance() {
        return companyWallet;
    }
}
