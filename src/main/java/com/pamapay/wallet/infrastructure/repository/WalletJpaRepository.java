package com.pamapay.wallet.infrastructure.repository;
import com.pamapay.wallet.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;
public interface WalletJpaRepository extends JpaRepository<WalletEntity,UUID> {
   Optional<WalletEntity> findByUserId(UUID userID);
   boolean existsByUserId(UUID userId);
}
