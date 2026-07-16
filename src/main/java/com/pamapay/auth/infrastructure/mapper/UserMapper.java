package com.pamapay.auth.infrastructure.mapper;


import com.pamapay.auth.domain.*;
import com.pamapay.auth.infrastructure.entity.UserEntity;


public class UserMapper {

     private UserMapper(){

     }
    public static UserEntity toEntity(User user){

        return UserEntity.builder()

                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .passwordHash(user.getPasswordHash())
                .role(user.getRole().name())
                .status(user.getStatus().name())
                .createdAt(user.getCreatedAt())

                .build();

    }
    public static User toDomain(UserEntity entity){
         return User.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .passwordHash(entity.getPasswordHash())
                .role(UserRole.valueOf(entity.getRole()))
                .status(UserStatus.valueOf(entity.getStatus()))
                .createdAt(entity.getCreatedAt())
                .build();
    }
}