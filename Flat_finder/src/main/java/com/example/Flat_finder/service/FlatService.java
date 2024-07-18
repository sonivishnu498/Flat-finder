package com.example.Flat_finder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Flat_finder.entity.Flat;
import com.example.Flat_finder.entity.User;
import com.example.Flat_finder.repo.FlatRepository;

@Service
public class FlatService {

    @Autowired
    private FlatRepository flatRepository;

    public Flat postFlat(User owner, String location, double rent, int rooms) {
        Flat flat = new Flat();
        flat.setLocation(location);
        flat.setRent(rent);
        flat.setRooms(rooms);
        flat.setStatus("available");
        flat.setOwner(owner);
        return flatRepository.save(flat);
    }

    public List<Flat> getAllAvailableFlats() {
        return flatRepository.findAll().stream()
                .filter(flat -> "available".equals(flat.getStatus()))
                .toList();
    }

    public Optional<Flat> getFlatById(Long flatId) {
        return flatRepository.findById(flatId);
    }

    public void updateFlat(Flat flat) {
        flatRepository.save(flat);
    }
}
