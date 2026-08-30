package com.pamapay.ledger.domain;

import java.util.List;
import java.util.UUID;

public interface LedgerEntryRepository {

    LedgerEntry save(LedgerEntry ledgerEntry);

    List<LedgerEntry> findByWalletId(UUID walletId);

    List<LedgerEntry> findByTransactionId(UUID transactionId);
}