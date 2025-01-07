package com.Uber.Project.UberApp.Project.strategies;

import com.Uber.Project.UberApp.Project.entity.enums.PaymentMethod;
import com.Uber.Project.UberApp.Project.service.WalletTransactionService;
import com.Uber.Project.UberApp.Project.strategies.Impl.CashPaymentStrategy;
import com.Uber.Project.UberApp.Project.strategies.Impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }
}
