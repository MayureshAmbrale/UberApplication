package com.Uber.Project.UberApp.Project.service.impl;

import com.Uber.Project.UberApp.Project.dto.WalletTransactionDto;
import com.Uber.Project.UberApp.Project.entity.WalletTransaction;
import com.Uber.Project.UberApp.Project.repository.WalletTransactionRepository;
import com.Uber.Project.UberApp.Project.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }

}
