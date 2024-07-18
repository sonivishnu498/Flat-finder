package com.example.Flat_finder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flat_finder.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long> {
}
