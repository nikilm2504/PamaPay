package com.pamapay.wallet.application.usecase;

import com.pamapay.wallet.application.dto.WalletResponse;

import java.math.BigDecimal;
import java.util.UUID;

public interface DepositWalletUseCase {
    WalletResponse deposit(UUID userId, BigDecimal amount);
}
