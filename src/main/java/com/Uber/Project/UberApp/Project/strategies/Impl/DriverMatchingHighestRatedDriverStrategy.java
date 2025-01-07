package com.Uber.Project.UberApp.Project.strategies.Impl;

import com.Uber.Project.UberApp.Project.dto.RideRequestDto;
import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.RideRequest;
import com.Uber.Project.UberApp.Project.repository.DriverRepository;
import com.Uber.Project.UberApp.Project.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional()
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
