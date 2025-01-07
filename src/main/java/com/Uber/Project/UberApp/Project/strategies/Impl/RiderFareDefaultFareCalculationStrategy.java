package com.Uber.Project.UberApp.Project.strategies.Impl;
import com.Uber.Project.UberApp.Project.entity.RideRequest;
import com.Uber.Project.UberApp.Project.service.DistanceService;
import com.Uber.Project.UberApp.Project.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER;
    }
}
