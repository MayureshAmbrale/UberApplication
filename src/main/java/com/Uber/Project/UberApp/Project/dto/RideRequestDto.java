package com.Uber.Project.UberApp.Project.dto;

import com.Uber.Project.UberApp.Project.entity.Rider;
import com.Uber.Project.UberApp.Project.entity.enums.PaymentMethod;
import com.Uber.Project.UberApp.Project.entity.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;
    private PointDto dropOffLocation;
    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;

    private RiderDto rider;
    private Double fare;

    private RideRequestStatus rideRequestStatus;
}
