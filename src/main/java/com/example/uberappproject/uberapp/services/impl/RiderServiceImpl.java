package com.example.uberappproject.uberapp.services.impl;

import com.example.uberappproject.uberapp.dto.DriverDto;
import com.example.uberappproject.uberapp.dto.RideDto;
import com.example.uberappproject.uberapp.dto.RideRequestDto;
import com.example.uberappproject.uberapp.dto.RiderDto;
import com.example.uberappproject.uberapp.entities.RideRequest;
import com.example.uberappproject.uberapp.entities.Rider;
import com.example.uberappproject.uberapp.entities.User;
import com.example.uberappproject.uberapp.entities.enums.RideRequestStatus;
import com.example.uberappproject.uberapp.repositories.RideRequestRepository;
import com.example.uberappproject.uberapp.repositories.RiderRepository;
import com.example.uberappproject.uberapp.services.RiderService;
import com.example.uberappproject.uberapp.strategies.DriverMatchingStrategy;
import com.example.uberappproject.uberapp.strategies.RideFareCalculationStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStrategy driveMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private  final RiderRepository riderRepository;

    public RiderServiceImpl(ModelMapper modelMapper, RideFareCalculationStrategy rideFareCalculationStrategy, DriverMatchingStrategy driveMatchingStrategy, RideRequestRepository rideRequestRepository, RiderRepository riderRepository) {
        this.modelMapper = modelMapper;
        this.rideFareCalculationStrategy = rideFareCalculationStrategy;
        this.driveMatchingStrategy = driveMatchingStrategy;
        this.rideRequestRepository = rideRequestRepository;
        this.riderRepository = riderRepository;
    }

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        driveMatchingStrategy.findMatchingDriver(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return null;
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }
}
