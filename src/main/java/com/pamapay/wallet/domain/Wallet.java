package com.pamapay.wallet.domain;
import com.pamapay.auth.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.Currency;
import java.time.Instant;
import java.util.UUID;
@Getter
@Builder
public class Wallet {

        private UUID id;

        private UUID userId;

        private BigDecimal balance;

        private CurrencyCode currency;

        private WalletStatus status;

        private Instant createdAt;
    }

