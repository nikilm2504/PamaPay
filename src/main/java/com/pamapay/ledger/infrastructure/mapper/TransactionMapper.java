package com.pamapay.ledger.infrastructure.mapper;

import com.pamapay.ledger.domain.Transaction;
import com.pamapay.ledger.infrastructure.entity.TransactionEntity;

public final class TransactionMapper {
    private TransactionMapper(){
    }
    public static TransactionEntity toEntity(Transaction transaction) {

        return TransactionEntity.builder()
                .id(transaction.getId())
                .walletId(transaction.getWalletId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .status(transaction.getStatus())
                .createdAt(transaction.getCreatedAt())
                .build();
    }
    public static Transaction toDomain(TransactionEntity entity) {

        return Transaction.builder()
                .id(entity.getId())
                .walletId(entity.getWalletId())
                .amount(entity.getAmount())
                .type(entity.getType())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
