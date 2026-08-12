package com.pamapay.wallet.application.dto;
import com.pamapay.wallet.domain.CurrencyCode;
import com.pamapay.wallet.domain.WalletStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record WalletResponse(
        UUID walletId,
        UUID user_id,
        BigDecimal balance,
        CurrencyCode currency,
        WalletStatus status,
        Instant createdAt
) {
}
