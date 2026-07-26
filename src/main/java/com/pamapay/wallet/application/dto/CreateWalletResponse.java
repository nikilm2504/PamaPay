package com.pamapay.wallet.application.dto;

import com.pamapay.wallet.domain.CurrencyCode;
import com.pamapay.wallet.domain.WalletStatus;
import com.pamapay.wallet.domain.Wallet;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record CreateWalletResponse(
         UUID walletId,

         UUID userId,

         BigDecimal balance,

         CurrencyCode currency,

         WalletStatus status,

         Instant createdAt,

         String message
) {

}
