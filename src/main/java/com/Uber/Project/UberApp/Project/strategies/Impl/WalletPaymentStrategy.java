package com.Uber.Project.UberApp.Project.strategies.Impl;

import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.Payment;
import com.Uber.Project.UberApp.Project.entity.Rider;
import com.Uber.Project.UberApp.Project.entity.enums.PaymentStatus;
import com.Uber.Project.UberApp.Project.entity.enums.TransactionMethod;
import com.Uber.Project.UberApp.Project.repository.PaymentRepository;
import com.Uber.Project.UberApp.Project.service.PaymentService;
import com.Uber.Project.UberApp.Project.service.WalletService;
import com.Uber.Project.UberApp.Project.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driversCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
