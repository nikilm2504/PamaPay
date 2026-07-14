package com.pamapay.auth.application.dto;

import java.util.UUID;

public record RegisterUserResponse(

        UUID userId,
        String fullName,
        String email,
        String message

) {
}