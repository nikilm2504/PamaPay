package com.pamapay.ledger.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(UUID transactionId);

    List<Transaction> findByWalletId(UUID walletId);
}