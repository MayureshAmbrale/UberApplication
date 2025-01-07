package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.dto.DriverDto;
import com.Uber.Project.UberApp.Project.dto.RiderDto;
import com.Uber.Project.UberApp.Project.entity.Ride;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
