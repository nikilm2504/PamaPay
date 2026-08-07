package com.pamapay.wallet.application.service;

import com.pamapay.auth.infrastructure.repository.UserJpaRepository;
import com.pamapay.auth.exception.UserNotFoundException;
import com.pamapay.common.exception.WalletAlreadyExistsException;
import com.pamapay.wallet.application.dto.CreateWalletResponse;
import com.pamapay.wallet.application.usecase.CreateWalletUseCase;
import com.pamapay.wallet.domain.CurrencyCode;
import com.pamapay.wallet.domain.Wallet;
import com.pamapay.wallet.domain.WalletRepository;
import com.pamapay.wallet.domain.WalletStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class CreateWalletService implements CreateWalletUseCase {

    private final WalletRepository walletRepository;
    private final UserJpaRepository userJpaRepository;

    public CreateWalletService(
            WalletRepository walletRepository,
            UserJpaRepository userJpaRepository) {

        this.walletRepository = walletRepository;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public CreateWalletResponse createwallet(UUID userId) {

        if (!userJpaRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }

        if (walletRepository.existsByUserId(userId)) {
            throw new WalletAlreadyExistsException(userId);
        }

        Wallet wallet = Wallet.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .balance(BigDecimal.ZERO)
                .currency(CurrencyCode.INR)
                .status(WalletStatus.ACTIVE)
                .createdAt(Instant.now())
                .build();

        Wallet savedWallet = walletRepository.save(wallet);

        return new CreateWalletResponse(
                savedWallet.getId(),
                savedWallet.getUserId(),
                savedWallet.getBalance(),
                savedWallet.getCurrency(),
                savedWallet.getStatus(),
                savedWallet.getCreatedAt(),
                "Wallet created successfully."
        );
    }
}