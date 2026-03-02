package com.example.uberappproject.uberapp.strategies;

import com.example.uberappproject.uberapp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
