package com.example.uberappproject.uberapp.strategies;

import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.entities.Driver;

import java.util.List;

public interface DriveMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
