package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.dto.DriverDto;
import com.Uber.Project.UberApp.Project.dto.RideDto;
import com.Uber.Project.UberApp.Project.dto.RideRequestDto;
import com.Uber.Project.UberApp.Project.dto.RiderDto;
import com.Uber.Project.UberApp.Project.entity.Rider;
import com.Uber.Project.UberApp.Project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
