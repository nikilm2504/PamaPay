package com.pamapay.ledger.infrastructure.repositoty;

import com.pamapay.ledger.infrastructure.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findByWalletId(UUID walletId);
}
