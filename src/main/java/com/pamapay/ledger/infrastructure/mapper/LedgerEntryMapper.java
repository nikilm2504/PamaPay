package com.pamapay.ledger.infrastructure.mapper;

import com.pamapay.ledger.domain.LedgerEntry;
import com.pamapay.ledger.infrastructure.entity.LedgerEntryEntity;

public final class LedgerEntryMapper {
    private LedgerEntryMapper(){
    }
    public static LedgerEntryEntity toEntity(LedgerEntry entry) {

        return LedgerEntryEntity.builder()
                .id(entry.getId())
                .walletId(entry.getWalletId())
                .transactionId(entry.getTransactionId())
                .type(entry.getType())
                .amount(entry.getAmount())
                .balanceAfter(entry.getBalanceAfter())
                .createdAt(entry.getCreatedAt())
                .build();
    }

    public static LedgerEntry toDomain(LedgerEntryEntity entity) {

        return LedgerEntry.builder()
                .id(entity.getId())
                .walletId(entity.getWalletId())
                .transactionId(entity.getTransactionId())
                .type(entity.getType())
                .amount(entity.getAmount())
                .balanceAfter(entity.getBalanceAfter())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

