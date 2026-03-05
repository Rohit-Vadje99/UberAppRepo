package com.example.uberappproject.uberapp.entities;

import com.example.uberappproject.uberapp.entities.enums.PaymentMethod;
import com.example.uberappproject.uberapp.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
public class RideRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;
    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime requestedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(value = EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    private Double fare;

    public Long getId() {
        return this.id;
    }

    public Point getPickupLocation() {
        return this.pickupLocation;
    }

    public Point getDropOffLocation() {
        return this.dropOffLocation;
    }

    public LocalDateTime getRequestedTime() {
        return this.requestedTime;
    }

    public Rider getRider() {
        return this.rider;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public RideRequestStatus getRideRequestStatus() {
        return this.rideRequestStatus;
    }

    public Double getFare() {
        return this.fare;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPickupLocation(Point pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropOffLocation(Point dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setRequestedTime(LocalDateTime requestedTime) {
        this.requestedTime = requestedTime;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setRideRequestStatus(RideRequestStatus rideRequestStatus) {
        this.rideRequestStatus = rideRequestStatus;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
