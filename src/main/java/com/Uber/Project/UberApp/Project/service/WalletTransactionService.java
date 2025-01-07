package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.dto.WalletTransactionDto;
import com.Uber.Project.UberApp.Project.entity.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);

}
