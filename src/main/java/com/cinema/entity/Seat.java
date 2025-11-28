package com.cinema.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", nullable = false)
    private CinemaHall hall;

    private Integer rowNumber; // номер ряда
    private Integer seatNumber; // номер места в ряду

    @Enumerated(EnumType.STRING)
    private SeatType seatType; // REGULAR, VIP

    @ManyToMany(mappedBy = "seats")
    private List<Booking> bookings = new ArrayList<>();

    // constructors, getters, setters
}
