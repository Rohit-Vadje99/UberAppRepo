package com.example.uberappproject.uberapp.entities;

import com.example.uberappproject.uberapp.entities.enums.PaymentMethod;
import com.example.uberappproject.uberapp.entities.enums.RideRequestStatus;
import com.example.uberappproject.uberapp.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;
    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(value = EnumType.STRING)
    private RideStatus rideStatus;

    private Double fare;
    private String otp;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
