package com.pamapay.wallet.application.service;

import com.pamapay.auth.exception.WalletNotFoundException;
import com.pamapay.wallet.application.dto.WalletResponse;
import com.pamapay.wallet.application.usecase.DepositWalletUseCase;
import com.pamapay.wallet.domain.Wallet;
import com.pamapay.wallet.domain.WalletRepository;
import com.pamapay.wallet.domain.WalletStatus;
import com.pamapay.wallet.exception.InvalidDepositAmountException;
import com.pamapay.wallet.exception.WalletNotActiveException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
@Service
public class DepositWalletSerice implements DepositWalletUseCase {
    private final WalletRepository walletRepository;
    public DepositWalletSerice(WalletRepository walletRepository){
        this.walletRepository=walletRepository;
    }
    @Override
    @Transactional
    public WalletResponse deposit(UUID userId, BigDecimal amount){
        if(amount==null || amount.compareTo(BigDecimal.ZERO) <=0){
            throw new InvalidDepositAmountException(amount);
         }
        Wallet wallet = walletRepository.findByUserId(userId).orElseThrow(WalletNotFoundException::new);
        if(wallet.getStatus()!= WalletStatus.ACTIVE){
            throw new WalletNotActiveException();
        }
        wallet.setBalance(wallet.getBalance().add(amount));
        Wallet savedWallet=walletRepository.save(wallet);
        return new WalletResponse(
                savedWallet.getId(),
                savedWallet.getUserId(),
                savedWallet.getBalance(),
                savedWallet.getCurrency(),
                savedWallet.getStatus(),
                savedWallet.getCreatedAt()
        );
    }
}
