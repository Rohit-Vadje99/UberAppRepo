package com.example.uberappproject.uberapp.strategies;

import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.entities.Driver;
import com.example.uberappproject.uberapp.entities.RideRequest;

import java.util.List;

public interface DriveMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
