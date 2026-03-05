package com.example.uberappproject.uberapp.entities;

import jakarta.persistence.*;

@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double rating;

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
