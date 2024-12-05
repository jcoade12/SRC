package com.golfclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golfclub.models.Tournament;
import com.golfclub.repositories.TournamentRepository;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    // Create a new tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Other methods like find, delete, etc.
}
