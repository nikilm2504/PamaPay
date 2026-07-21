package com.pamapay.auth.application.service;
import com.pamapay.auth.application.dto.LoginRequest;
import com.pamapay.auth.application.dto.LoginResponse;
import com.pamapay.auth.application.usecase.LoginUseCase;
import com.pamapay.auth.infrastructure.repository.UserJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pamapay.auth.infrastructure.entity.UserEntity;
import com.pamapay.common.exception.InvalidCredentialsException;
@Service
public class LoginService implements LoginUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserJpaRepository userJpaRepository;
    public LoginService(
            PasswordEncoder passwordEncoder,
            UserJpaRepository userJpaRepository
    ){
        this.passwordEncoder=passwordEncoder;
        this.userJpaRepository=userJpaRepository;
    }
        @Override
        public LoginResponse login(LoginRequest request) {

            UserEntity userEntity = userJpaRepository
                    .findByEmail(request.email().trim().toLowerCase())
                    .orElseThrow(() ->
                            new InvalidCredentialsException("Invalid email or password"));

            if (!passwordEncoder.matches(
                    request.password(),
                    userEntity.getPasswordHash())) {

                throw new InvalidCredentialsException("Invalid email or password");
            }

            throw new UnsupportedOperationException("JWT generation not implemented yet");
        }
    }


