package com.pamapay.auth.application.usecase;
import com.pamapay.auth.application.dto.LoginRequest;
import com.pamapay.auth.application.dto.LoginResponse;
public interface LoginUseCase {
     LoginResponse login(LoginRequest request);
}
