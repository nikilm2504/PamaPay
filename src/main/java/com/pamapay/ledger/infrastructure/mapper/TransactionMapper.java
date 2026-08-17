package com.pamapay.ledger.infrastructure.mapper;

import com.pamapay.ledger.domain.Transaction;
import com.pamapay.ledger.infrastructure.entity.TransactionEntity;

public final class TransactionMapper {
    private TransactionMapper(){

    }
    public static TransactionEntity toEntity(Transaction transaction){
           return TransactionEntity.builder()
                   .id(transaction.getId()),
                   .
    }
}
