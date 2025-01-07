package com.Uber.Project.UberApp.Project.strategies.Impl;

import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.Payment;
import com.Uber.Project.UberApp.Project.entity.enums.PaymentStatus;
import com.Uber.Project.UberApp.Project.entity.enums.TransactionMethod;
import com.Uber.Project.UberApp.Project.repository.PaymentRepository;
import com.Uber.Project.UberApp.Project.service.PaymentService;
import com.Uber.Project.UberApp.Project.service.WalletService;
import com.Uber.Project.UberApp.Project.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider -> 100
//Driver -> 70 Deduct 30Rs from Driver's wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}