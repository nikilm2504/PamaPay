package com.pamapay.wallet.domain;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository {
    Wallet save(Wallet wallet);
    Optional<Wallet> findById(UUID walletId);
    Optional<Wallet> findByUserId(UUID userId);
    boolean existsByUserId(UUID userId);
}
