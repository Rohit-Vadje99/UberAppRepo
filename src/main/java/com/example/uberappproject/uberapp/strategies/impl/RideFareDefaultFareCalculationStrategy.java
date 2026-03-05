package com.example.uberappproject.uberapp.strategies.impl;

import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.services.DistanceService;
import com.example.uberappproject.uberapp.strategies.RideFareCalculationStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    public RideFareDefaultFareCalculationStrategy(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double disatance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());

        return disatance * RIDE_FARE_MULTIPLIER;

    }
}
