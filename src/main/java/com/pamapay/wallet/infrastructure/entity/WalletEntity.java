package com.pamapay.wallet.infrastructure.entity;

import com.pamapay.wallet.domain.CurrencyCode;
import com.pamapay.wallet.domain.WalletStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="wallets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletEntity {
   @Id
   private UUID id;
   @Column(name="user_id",nullable = false,unique=true)
   private UUID userId;
   @Column(nullable=false,precision = 19,scale=2)
   private BigDecimal balance;
   @Enumerated(EnumType.STRING)
   @Column(nullable=false,unique=true)
   private CurrencyCode currency;
   @Enumerated(EnumType.STRING)
   @Column(nullable=false)
   private WalletStatus status;
   @Column(name="created_at",nullable=false)
   private Instant createdAt;

}
