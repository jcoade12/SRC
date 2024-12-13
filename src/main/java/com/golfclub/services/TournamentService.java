package com.golfclub.services;

import java.util.List;
import java.util.Optional;

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

    // Retrieve all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Retrieve a tournament by ID
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    // Retrieve a tournament or throw an exception if not found
    public Tournament getTournamentByIdOrThrow(Long id) {
        return tournamentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + id));
    }

    // Save or update a tournament
    public Tournament saveTournament(Tournament tournament) {
        if (tournament.getStartDate().isAfter(tournament.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date.");
        }
        return tournamentRepository.save(tournament);
    }

    // Delete a tournament by ID
    public void deleteTournament(Long id) {
        if (!tournamentRepository.existsById(id)) {
            throw new RuntimeException("Tournament not found with ID: " + id);
        }
        tournamentRepository.deleteById(id);
    }

    public Tournament createTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
