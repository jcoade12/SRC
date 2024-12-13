package com.golfclub.models;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Start date cannot be null")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NotNull(message = "Location cannot be null")
    @Column(name = "location", nullable = false)
    private String location;

    @NotNull(message = "Entry fee cannot be null")
    @Positive(message = "Entry fee must be positive")
    @Column(name = "entry_fee", nullable = false)
    private Double entryFee;

    @NotNull(message = "Cash prize cannot be null")
    @Positive(message = "Cash prize must be positive")
    @Column(name = "cash_prize", nullable = false)
    private Double cashPrize;

    // Default constructor
    public Tournament() {}

    // Constructor for initialization
    public Tournament(LocalDate startDate, LocalDate endDate, String location, Double entryFee, Double cashPrize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
    }

    // Validation for logical date consistency
    @Transient
    public boolean isStartDateBeforeEndDate() {
        return startDate.isBefore(endDate);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Double entryFee) {
        this.entryFee = entryFee;
    }

    public Double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(Double cashPrize) {
        this.cashPrize = cashPrize;
    }

    // Override equals and hashCode for entity comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Override toString for better logging and debugging
    @Override
    public String toString() {
        return "Tournament{" +
               "id=" + id +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", location='" + location + '\'' +
               ", entryFee=" + entryFee +
               ", cashPrize=" + cashPrize +
               '}';
    }
}
