package com.pamapay.ledger.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
@Getter
@Builder
public class LedgerEntry {
    private final UUID id;
    private final UUID walletId;
    private final UUID transactionId;
    private final LedgerEntryType type;
    private final BigDecimal amount;
    private final  BigDecimal balanceAfter;
    private final Instant createdAt;

}
