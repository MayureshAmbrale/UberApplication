package com.Uber.Project.UberApp.Project.service.impl;

import com.Uber.Project.UberApp.Project.entity.Payment;
import com.Uber.Project.UberApp.Project.entity.Ride;
import com.Uber.Project.UberApp.Project.entity.enums.PaymentMethod;
import com.Uber.Project.UberApp.Project.entity.enums.PaymentStatus;
import com.Uber.Project.UberApp.Project.exception.ResourceNotFoundException;
import com.Uber.Project.UberApp.Project.repository.PaymentRepository;
import com.Uber.Project.UberApp.Project.service.PaymentService;
import com.Uber.Project.UberApp.Project.strategies.PaymentStrategyManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentStrategyManager paymentStrategyManager;

    @Override
    public void processPayment(Ride ride) {
        Payment payment = paymentRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for ride with id: "+ride.getId()));
        paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);
    }

    @Override
    public Payment createNewPayment(Ride ride) {
        Payment payment = Payment.builder()
                .ride(ride)
                .paymentMethod(ride.getPaymentMethod())
                .amount(ride.getFare())
                .paymentStatus(PaymentStatus.PENDING)
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public void updatePaymentStatus(Payment payment, PaymentStatus status) {
        payment.setPaymentStatus(status);
        paymentRepository.save(payment);
    }
}
