package com.example.uberappproject.uberapp.strategies.impl;

import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.entities.Driver;
import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.strategies.DriveMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriveMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return null;
    }
}
