package com.cinema.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private Integer durationMinutes; // продолжительность в минутах
    private String genre;
    private String director;

    @OneToMany(mappedBy = "film")
    private List<Screening> screenings = new ArrayList<>();

    // constructors, getters, setters
}