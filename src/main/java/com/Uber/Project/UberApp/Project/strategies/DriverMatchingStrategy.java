package com.Uber.Project.UberApp.Project.strategies;

import com.Uber.Project.UberApp.Project.dto.RideRequestDto;
import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
