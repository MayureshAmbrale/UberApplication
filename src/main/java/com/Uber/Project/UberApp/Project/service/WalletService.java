package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.entity.Ride;
import com.Uber.Project.UberApp.Project.entity.User;
import com.Uber.Project.UberApp.Project.entity.Wallet;
import com.Uber.Project.UberApp.Project.entity.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount,
                            String transactionId, Ride ride,
                            TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount,
                                 String transactionId, Ride ride,
                                 TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);

}
