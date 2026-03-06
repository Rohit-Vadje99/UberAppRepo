package com.example.uberappproject.uberapp.strategies.impl;

import com.example.uberappproject.uberapp.entities.Driver;
import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.repositories.DriverRepository;
import com.example.uberappproject.uberapp.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    public DriverMatchingHighestRatedDriverStrategy(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {

        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
