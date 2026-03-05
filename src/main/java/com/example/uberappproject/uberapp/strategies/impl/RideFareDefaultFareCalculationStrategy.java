package com.example.uberappproject.uberapp.strategies.impl;

import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.services.DistanceService;
import com.example.uberappproject.uberapp.strategies.RideFareCalculationStrategy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double disatance = distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropOffLocation());

        return disatance*RIDE_FARE_MULTIPLIER;

    }
}
