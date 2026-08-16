package com.pamapay.transaction.domain;

import com.pamapay.ledger.domain.TransactionStatus;
import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import com.pamapay.transaction.domain.TransactionType;
@Getter
@Builder
public class Transaction {

    private final UUID id;

    private final UUID walletId;

    private final BigDecimal amount;

    private final TransactionType type;

    private final TransactionStatus status;

    private final Instant createdAt;
}