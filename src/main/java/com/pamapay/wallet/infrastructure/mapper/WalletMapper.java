package com.pamapay.wallet.infrastructure.mapper;
import com.pamapay.wallet.infrastructure.entity.WalletEntity;
import com.pamapay.wallet.domain.Wallet;

public final class WalletMapper {
   private WalletMapper(){
   }
   public static WalletEntity toEntity(Wallet wallet){
       return WalletEntity.builder()
               .id(wallet.getId())
               .userId(wallet.getUserId())
               .balance(wallet.getBalance())
               .currency(wallet.getCurrency())
               .status(wallet.getStatus())
               .createdAt(wallet.getCreatedAt())
               .build();
    }
    public static Wallet toDomain(WalletEntity entity){
        return Wallet.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .balance(entity.getBalance())
                .currency(entity.getCurrency())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
