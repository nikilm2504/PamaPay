package com.pamapay.wallet.application.service;

import com.pamapay.auth.exception.WalletNotFoundException;
import com.pamapay.wallet.application.dto.WalletResponse;
import com.pamapay.wallet.application.usecase.GetWalletUseCase;
import com.pamapay.wallet.domain.Wallet;
import com.pamapay.wallet.domain.WalletRepository;

import java.util.UUID;

public class GetWalletService implements GetWalletUseCase {
    private final WalletRepository walletRepository;
    public GetWalletService(WalletRepository walletRepository){
        this.walletRepository=walletRepository;
    }

    @Override
    public WalletResponse getWallet(UUID userId){
        Wallet wallet=walletRepository.findByUserId(userId).orElseThrow(WalletNotFoundException::new);
        return new WalletResponse(
                wallet.getId(),
                wallet.getUserId(),
                wallet.getBalance(),
                wallet.getCurrency(),
                wallet.getStatus(),
                wallet.getCreatedAt()
        );
    }
}
