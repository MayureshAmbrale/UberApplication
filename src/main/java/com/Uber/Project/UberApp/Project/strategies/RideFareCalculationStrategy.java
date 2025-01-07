package com.Uber.Project.UberApp.Project.strategies;

import com.Uber.Project.UberApp.Project.entity.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
