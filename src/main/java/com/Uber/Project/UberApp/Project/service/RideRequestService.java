package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.entity.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
