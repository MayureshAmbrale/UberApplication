package com.Uber.Project.UberApp.Project.strategies.Impl;

import com.Uber.Project.UberApp.Project.dto.RideRequestDto;
import com.Uber.Project.UberApp.Project.entity.RideRequest;
import com.Uber.Project.UberApp.Project.service.DistanceService;
import com.Uber.Project.UberApp.Project.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
}

