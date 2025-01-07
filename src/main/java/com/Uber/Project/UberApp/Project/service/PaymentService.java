package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.entity.Payment;
import com.Uber.Project.UberApp.Project.entity.Ride;
import com.Uber.Project.UberApp.Project.entity.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}

