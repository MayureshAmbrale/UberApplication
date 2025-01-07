package com.Uber.Project.UberApp.Project.strategies;

import com.Uber.Project.UberApp.Project.entity.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);

}
