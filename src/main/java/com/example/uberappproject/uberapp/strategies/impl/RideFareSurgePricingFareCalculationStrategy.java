package com.example.uberappproject.uberapp.strategies.impl;

import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.services.DistanceService;
import com.example.uberappproject.uberapp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    public RideFareSurgePricingFareCalculationStrategy(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double disatance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());

        return disatance * RIDE_FARE_MULTIPLIER*SURGE_FACTOR;

    }
}
