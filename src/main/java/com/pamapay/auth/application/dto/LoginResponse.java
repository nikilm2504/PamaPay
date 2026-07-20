package com.pamapay.auth.application.dto;

public record LoginResponse(
       String accessToken,
       String tokenType
) {
}
