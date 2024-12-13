package com.golfclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.golfclub.models.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    // custom query methods if needed
}
