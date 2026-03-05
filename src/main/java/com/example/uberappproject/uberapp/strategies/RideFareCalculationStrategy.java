package com.example.uberappproject.uberapp.strategies;

import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
