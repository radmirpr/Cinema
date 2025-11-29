package com.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seats")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private CinemaHall hall;

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType = SeatType.REGULAR;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToMany(mappedBy = "seats", fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();
}

enum SeatType {
    REGULAR, VIP, COUPLE, DISABLED
}