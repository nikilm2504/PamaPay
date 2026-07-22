package com.pamapay.auth.application.service;
import com.pamapay.auth.application.dto.LoginRequest;
import com.pamapay.auth.application.dto.LoginResponse;
import com.pamapay.auth.application.usecase.LoginUseCase;
import com.pamapay.auth.domain.User;
import com.pamapay.auth.infrastructure.mapper.UserMapper;
import com.pamapay.auth.infrastructure.repository.UserJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pamapay.auth.infrastructure.entity.UserEntity;
import com.pamapay.common.exception.InvalidCredentialsException;
import com.pamapay.security.JwtService;
@Service
public class LoginService implements LoginUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserJpaRepository userJpaRepository;
    private final JwtService jwtService;
    public LoginService(
            PasswordEncoder passwordEncoder,
            UserJpaRepository userJpaRepository,
            JwtService jwtService
    ){
        this.passwordEncoder=passwordEncoder;
        this.userJpaRepository=userJpaRepository;
        this.jwtService = jwtService;
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

            User user = UserMapper.toDomain(userEntity);

            String accessToken = jwtService.generateAcessToken(user);

            return new LoginResponse(
                    accessToken,
                    "Bearer"
            );
    }
    }


