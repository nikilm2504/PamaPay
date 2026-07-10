package com.pamapay.auth.infrastructure.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {


    @Id
    private UUID id;


    @Column(nullable = false)
    private String name;


    @Column(
            nullable = false,
            unique = true
    )
    private String email;


    @Column(
            name = "password_hash",
            nullable = false
    )
    private String passwordHash;


    @Column(nullable = false)
    private String role;


    @Column(nullable = false)
    private String status;


    @Column(
            name = "created_at",
            nullable = false
    )
    private Instant createdAt;

}