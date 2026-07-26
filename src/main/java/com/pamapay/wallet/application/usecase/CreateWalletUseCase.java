package com.pamapay.wallet.application.usecase;
import com.pamapay.wallet.application.dto.CreateWalletResponse;

import java.util.UUID;

public interface CreateWalletUseCase {
    CreateWalletResponse createwallet(UUID userId);
}
