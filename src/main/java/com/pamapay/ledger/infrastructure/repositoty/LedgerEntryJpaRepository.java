package com.pamapay.ledger.infrastructure.repositoty;

import com.pamapay.ledger.domain.LedgerEntry;
import com.pamapay.ledger.infrastructure.entity.LedgerEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LedgerEntryJpaRepository extends JpaRepository<LedgerEntry, UUID> {
    List<LedgerEntryEntity> findByWalletId(UUID walletId);
    List<LedgerEntryEntity> findByTransactionId(UUID transactionId);
}
