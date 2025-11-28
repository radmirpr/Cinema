package com.cinema.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role; // ROLE_USER, ROLE_ADMIN

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    // constructors, getters, setters
}