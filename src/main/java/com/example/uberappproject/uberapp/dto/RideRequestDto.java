package com.example.uberappproject.uberapp.dto;


import com.example.uberappproject.uberapp.entities.enums.PaymentMethod;
import com.example.uberappproject.uberapp.entities.enums.RideRequestStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;


    private Point pickupLocation;

    private Point dropOffLocation;


    private LocalDateTime requestedTime;


    private RiderDto rider;


    private PaymentMethod paymentMethod;


    private RideRequestStatus rideRequestStatus;
}
