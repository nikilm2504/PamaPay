package com.pamapay.wallet.application.usecase;

import com.pamapay.wallet.application.dto.WalletResponse;

import java.util.UUID;

public interface GetWalletUseCase {
    WalletResponse getWallet(UUID userId);
}
