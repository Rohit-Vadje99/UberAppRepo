package com.example.uberappproject.uberapp.entities;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double rating;

    private Boolean available;
    private String vehicleId;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point currentLocation;

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Double getRating() {
        return this.rating;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public Point getCurrentLocation() {
        return this.currentLocation;
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

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }
}
