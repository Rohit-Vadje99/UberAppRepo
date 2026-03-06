package com.example.uberappproject.uberapp.services;

import com.example.uberappproject.uberapp.dto.DriverDto;
import com.example.uberappproject.uberapp.dto.RideDto;
import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.dto.RiderDto;
import com.example.uberappproject.uberapp.entities.Rider;
import com.example.uberappproject.uberapp.entities.User;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);
    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);
    RiderDto getMyProfile();

    List<RideDto> getAllMyRides();

    Rider createNewRider(User user);
    Rider getCurrentRider();
}
