package com.cinema.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "cinema_halls")
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer capacity; // общее количество мест

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "hall")
    private List<Screening> screenings = new ArrayList<>();

    // constructors, getters, setters
}
