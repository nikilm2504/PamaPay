package com.pamapay.auth.infrastructure.mapper;


import com.pamapay.auth.domain.*;
import com.pamapay.auth.infrastructure.entity.UserEntity;


public class UserMapper {


    public static UserEntity toEntity(User user){

        return UserEntity.builder()

                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .passwordHash(user.getPasswordHash())
                .role(user.getRole().name())
                .status(user.getStatus().name())
                .createdAt(user.getCreatedAt())

                .build();

    }

}