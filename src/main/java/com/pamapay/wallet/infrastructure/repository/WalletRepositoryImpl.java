package com.pamapay.wallet.infrastructure.repository;

import com.pamapay.wallet.domain.Wallet;
import com.pamapay.wallet.domain.WalletRepository;
import com.pamapay.wallet.infrastructure.entity.WalletEntity;
import com.pamapay.wallet.infrastructure.mapper.WalletMapper;

import java.util.Optional;
import java.util.UUID;

public class WalletRepositoryImpl implements WalletRepository {
    private final WalletJpaRepository walletJpaRepository;
    public WalletRepositoryImpl(WalletJpaRepository walletJpaRepository){
        this.walletJpaRepository=walletJpaRepository;
    }
    @Override
    public Wallet save(Wallet wallet){
        WalletEntity entity = WalletMapper.toEntity(wallet);
        WalletEntity savedEntity = walletJpaRepository.save(entity);
        return WalletMapper.toDomain(savedEntity);
    }
    @Override
    public Optional<Wallet> findById(UUID walletId){
         return walletJpaRepository.findById(walletId)
                 .map(WalletMapper::toDomain);
    }
    @Override
    public Optional<Wallet> findByUserId(UUID userId) {

        return walletJpaRepository.findByUserId(userId)
                .map(WalletMapper::toDomain);
    }
    @Override
    public boolean existsByUserId(UUID userId) {

        return walletJpaRepository.existsByUserId(userId);
    }
}
