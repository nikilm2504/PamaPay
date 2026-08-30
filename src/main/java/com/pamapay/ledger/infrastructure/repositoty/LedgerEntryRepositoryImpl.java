package com.pamapay.ledger.infrastructure.repository;

import com.pamapay.ledger.domain.LedgerEntry;
import com.pamapay.ledger.domain.LedgerEntryRepository;
import com.pamapay.ledger.infrastructure.entity.LedgerEntryEntity;
import com.pamapay.ledger.infrastructure.mapper.LedgerEntryMapper;
import com.pamapay.ledger.infrastructure.repositoty.LedgerEntryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class LedgerEntryRepositoryImpl implements LedgerEntryRepository {

    private final LedgerEntryJpaRepository ledgerEntryJpaRepository;

    public LedgerEntryRepositoryImpl(
            LedgerEntryJpaRepository ledgerEntryJpaRepository) {

        this.ledgerEntryJpaRepository = ledgerEntryJpaRepository;
    }

    @Override
    public LedgerEntry save(LedgerEntry ledgerEntry) {

        LedgerEntryEntity entity =
                LedgerEntryMapper.toEntity(ledgerEntry);

        LedgerEntryEntity savedEntity =
                ledgerEntryJpaRepository.save(entity);

        return LedgerEntryMapper.toDomain(savedEntity);
    }

    @Override
    public List<LedgerEntry> findByWalletId(UUID walletId) {

        return ledgerEntryJpaRepository.findByWalletId(walletId)
                .stream()
                .map(LedgerEntryMapper::toDomain)
                .toList();
    }

    @Override
    public List<LedgerEntry> findByTransactionId(UUID transactionId) {

        return ledgerEntryJpaRepository.findByTransactionId(transactionId)
                .stream()
                .map(LedgerEntryMapper::toDomain)
                .toList();
    }
}