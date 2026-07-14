package com.pamapay.auth.application.service;

import com.pamapay.auth.application.dto.RegisterUserRequest;
import com.pamapay.auth.application.dto.RegisterUserResponse;
import com.pamapay.auth.application.usecase.RegisterUserUseCase;
import com.pamapay.auth.infrastructure.mapper.UserMapper;
import com.pamapay.auth.infrastructure.repository.UserJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public RegisterUserService(
            UserJpaRepository userJpaRepository,
            PasswordEncoder passwordEncoder,
            UserMapper userMapper) {

        this.userJpaRepository = userJpaRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {

        if (userJpaRepository.existsByEmail(request.email())) {

            throw new EmailAlreadyExistsException(request.email());

        }

        throw new UnsupportedOperationException("User creation not implemented yet");

    }