package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.dto.RideRequestDto;
import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.Ride;
import com.Uber.Project.UberApp.Project.entity.RideRequest;
import com.Uber.Project.UberApp.Project.entity.Rider;
import com.Uber.Project.UberApp.Project.entity.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
