package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.dto.DriverDto;
import com.Uber.Project.UberApp.Project.dto.RideDto;
import com.Uber.Project.UberApp.Project.dto.RiderDto;
import com.Uber.Project.UberApp.Project.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver, boolean available);

    Driver createNewDriver(Driver driver);
}
