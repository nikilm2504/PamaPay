package com.pamapay.ledger.infrastructure.repository;

import com.pamapay.ledger.domain.Transaction;
import com.pamapay.ledger.domain.TransactionRepository;
import com.pamapay.ledger.infrastructure.entity.TransactionEntity;
import com.pamapay.ledger.infrastructure.mapper.TransactionMapper;
import com.pamapay.ledger.infrastructure.repositoty.TransactionJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionJpaRepository transactionJpaRepository;

    public TransactionRepositoryImpl(
            TransactionJpaRepository transactionJpaRepository) {

        this.transactionJpaRepository = transactionJpaRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {

        TransactionEntity entity =
                TransactionMapper.toEntity(transaction);

        TransactionEntity savedEntity =
                transactionJpaRepository.save(entity);

        return TransactionMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Transaction> findById(UUID transactionId) {

        return transactionJpaRepository.findById(transactionId)
                .map(TransactionMapper::toDomain);
    }

    @Override
    public List<Transaction> findByWalletId(UUID walletId) {

        return transactionJpaRepository.findByWalletId(walletId)
                .stream()
                .map(TransactionMapper::toDomain)
                .toList();
    }
}