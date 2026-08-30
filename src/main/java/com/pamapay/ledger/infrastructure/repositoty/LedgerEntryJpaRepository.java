package com.pamapay.ledger.infrastructure.repository;

import com.pamapay.ledger.infrastructure.entity.LedgerEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LedgerEntryJpaRepository
        extends JpaRepository<LedgerEntryEntity, UUID> {

    List<LedgerEntryEntity> findByWalletId(UUID walletId);

    List<LedgerEntryEntity> findByTransactionId(UUID transactionId);
}