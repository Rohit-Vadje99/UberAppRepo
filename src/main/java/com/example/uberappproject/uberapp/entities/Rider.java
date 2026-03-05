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

    Rider(Long id, User user, Double rating) {
        this.id = id;
        this.user = user;
        this.rating = rating;
    }

    public static RiderBuilder builder() {
        return new RiderBuilder();
    }

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

    public static class RiderBuilder {
        private Long id;
        private User user;
        private Double rating;

        RiderBuilder() {
        }

        public RiderBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RiderBuilder user(User user) {
            this.user = user;
            return this;
        }

        public RiderBuilder rating(Double rating) {
            this.rating = rating;
            return this;
        }

        public Rider build() {
            return new Rider(this.id, this.user, this.rating);
        }

        public String toString() {
            return "Rider.RiderBuilder(id=" + this.id + ", user=" + this.user + ", rating=" + this.rating + ")";
        }
    }
}
