package com.pamapay.auth.domain;
import lombok.*;
import java.time.Instant;
import java.util.UUID;
@Getter
@AllArgsConstructor
@Builder
public class User {

    private UUID id;

    private String fullName;

    private String email;

    private String passwordHash;

    private UserRole role;

    private UserStatus status;

    private Instant createdAt;


    public void activate(){

        this.status = UserStatus.ACTIVE;

    }


    public void block(){

        this.status = UserStatus.BLOCKED;

    }
}