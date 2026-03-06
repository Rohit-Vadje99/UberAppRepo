package com.example.uberappproject.uberapp.strategies;

import com.example.uberappproject.uberapp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.example.uberappproject.uberapp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.example.uberappproject.uberapp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.example.uberappproject.uberapp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public RideStrategyManager(DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy, DriverMatchingNearestDriverStrategy nearestDriverStrategy, RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy, RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy) {
        this.highestRatedDriverStrategy = highestRatedDriverStrategy;
        this.nearestDriverStrategy = nearestDriverStrategy;
        this.surgePricingFareCalculationStrategy = surgePricingFareCalculationStrategy;
        this.defaultFareCalculationStrategy = defaultFareCalculationStrategy;
    }

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if (riderRating >= 4.5){
            return highestRatedDriverStrategy;
        }else {
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

//        6pm to 9pm
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if (isSurgeTime){
            return surgePricingFareCalculationStrategy;
        }else {
            return defaultFareCalculationStrategy;
        }

    }
}
