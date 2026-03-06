package com.example.uberappproject.uberapp.strategies.impl;

import com.example.uberappproject.uberapp.entities.Driver;
import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.repositories.DriverRepository;
import com.example.uberappproject.uberapp.strategies.DriverMatchingStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    public DriverMatchingNearestDriverStrategy(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
//        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
        return new ArrayList<>();
    }
}
